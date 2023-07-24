package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.validation.BindingResult;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.OwnerRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class OwnerController_processCreationForm_9aa1f495ef_Test {

    private OwnerController ownerController;
    private OwnerRepository ownerRepository;
    private BindingResult bindingResult;

    @BeforeEach
    public void setup() {
        ownerRepository = Mockito.mock(OwnerRepository.class);
        bindingResult = Mockito.mock(BindingResult.class);
        ownerController = new OwnerController();
    }

    @Test
    public void testProcessCreationForm_Success() {
        Owner owner = new Owner();
        owner.setId(1);
        when(bindingResult.hasErrors()).thenReturn(false);
        when(ownerRepository.save(owner)).thenReturn(owner);
        String view = ownerController.processCreationForm(owner, bindingResult);
        assertEquals("redirect:/owners/1", view);
    }

    @Test
    public void testProcessCreationForm_Failure() {
        Owner owner = new Owner();
        when(bindingResult.hasErrors()).thenReturn(true);
        String view = ownerController.processCreationForm(owner, bindingResult);
        assertEquals("VIEWS_OWNER_CREATE_OR_UPDATE_FORM", view);
    }
}
