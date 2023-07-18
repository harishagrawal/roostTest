package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.validation.BindingResult;

public class OwnerController_processCreationForm_9aa1f495ef_Test {

    @InjectMocks
    private OwnerController ownerController;

    @Mock
    private OwnerRepository owners;

    @Mock
    private BindingResult result;

    @Mock
    private Owner owner;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testProcessCreationForm_Success() {
        when(result.hasErrors()).thenReturn(false);
        when(owner.getId()).thenReturn(1);
        when(owners.save(owner)).thenReturn(owner);

        String view = ownerController.processCreationForm(owner, result);

        assertEquals("redirect:/owners/1", view);
    }

    @Test
    public void testProcessCreationForm_Failure() {
        when(result.hasErrors()).thenReturn(true);

        String view = ownerController.processCreationForm(owner, result);

        assertEquals("ownerCreateOrUpdate", view);
    }
}
