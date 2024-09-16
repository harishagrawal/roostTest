package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class OwnerController_processCreationForm_9aa1f495ef_Test {

    @Mock
    private OwnerRepository owners;

    @InjectMocks
    private OwnerController controller;

    private Owner owner;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        owner = new Owner();
        owner.setId(1);
    }

    @Test
    public void testProcessCreationForm_success() {
        BindingResult result = new BeanPropertyBindingResult(owner, "owner");
        when(owners.save(owner)).thenReturn(owner);

        String view = controller.processCreationForm(owner, result);

        assertEquals("redirect:/owners/1", view);
    }

    @Test
    public void testProcessCreationForm_hasErrors() {
        BindingResult result = new BeanPropertyBindingResult(owner, "owner");
        result.reject("error");
        String view = controller.processCreationForm(owner, result);

        assertEquals("owners/createOrUpdateOwnerForm", view);
    }
}
