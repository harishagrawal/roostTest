package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class OwnerController2_OwnerController2_cb93b59b02_Test {

    @Mock
    private OwnerRepository clinicService;

    @InjectMocks
    private OwnerController2 ownerController2;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testOwnerController2_success() {
        Owner owner = new Owner();
        when(clinicService.save(any(Owner.class))).thenReturn(owner);
        ownerController2.processCreationForm(owner);
        verify(clinicService).save(any(Owner.class));
    }

    @Test
    public void testOwnerController2_failure() {
        when(clinicService.save(null)).thenThrow(new NullPointerException());
        try {
            ownerController2.processCreationForm(null);
        } catch (NullPointerException e) {
            //expected exception
        }
    }
}
