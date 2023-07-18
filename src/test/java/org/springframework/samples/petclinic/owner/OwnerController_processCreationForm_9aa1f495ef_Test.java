package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BindingResult;
import org.springframework.validation.MapBindingResult;
import org.springframework.validation.ObjectError;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class OwnerController_processCreationForm_9aa1f495ef_Test {

    private OwnerRepository owners;
    private Owner owner;
    private BindingResult result;

    @BeforeEach
    public void setup() {
        owners = mock(OwnerRepository.class);
        owner = new Owner();
        owner.setId(1);
        result = new MapBindingResult(new HashMap<>(), "");
    }

    @Test
    public void testProcessCreationForm_success() {
        when(result.hasErrors()).thenReturn(false);
        when(owners.save(any(Owner.class))).thenReturn(owner);

        OwnerController ownerController = new OwnerController(owners);
        String view = ownerController.processCreationForm(owner, result);

        assertEquals("redirect:/owners/1", view);
    }

    @Test
    public void testProcessCreationForm_failure() {
        when(result.hasErrors()).thenReturn(true);
        result.addError(new ObjectError("", "some error"));

        OwnerController ownerController = new OwnerController(owners);
        String view = ownerController.processCreationForm(owner, result);

        assertEquals("owners/createOrUpdateOwnerForm", view);
    }
}
