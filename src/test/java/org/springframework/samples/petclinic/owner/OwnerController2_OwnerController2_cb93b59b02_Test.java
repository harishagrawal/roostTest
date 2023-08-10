package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class OwnerController2_OwnerController2_cb93b59b02_Test {

    @InjectMocks
    private OwnerController2 ownerController2;

    @Mock
    private OwnerRepository clinicService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testOwnerController2_constructor_success() {
        when(clinicService.count()).thenReturn(10L);

        assertEquals(10, ownerController2.owners.count());
    }

    @Test
    public void testOwnerController2_constructor_failure() {
        when(clinicService.count()).thenReturn(null);

        assertEquals(0, ownerController2.owners.count());
    }
}
