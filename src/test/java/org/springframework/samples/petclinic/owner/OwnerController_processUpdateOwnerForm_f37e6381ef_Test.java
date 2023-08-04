package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.validation.BindingResult;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class OwnerController_processUpdateOwnerForm_f37e6381ef_Test {

    @InjectMocks
    OwnerController ownerController = new OwnerController();

    @Mock
    OwnerRepository owners = mock(OwnerRepository.class);

    @Mock
    BindingResult result = mock(BindingResult.class);

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testProcessUpdateOwnerForm_success() {
        Owner owner = new Owner();
        owner.setFirstName("John");
        owner.setLastName("Doe");
        when(result.hasErrors()).thenReturn(false);

        String view = ownerController.processUpdateOwnerForm(owner, result, 1);
        assertEquals("redirect:/owners/{ownerId}", view);
        verify(owners, times(1)).save(owner);
    }

    @Test
    public void testProcessUpdateOwnerForm_failure() {
        Owner owner = new Owner();
        owner.setFirstName("John");
        owner.setLastName("Doe");
        when(result.hasErrors()).thenReturn(true);

        String view = ownerController.processUpdateOwnerForm(owner, result, 1);
        assertEquals("owners/createOrUpdateOwnerForm", view);
        verify(owners, times(0)).save(owner);
    }
}
