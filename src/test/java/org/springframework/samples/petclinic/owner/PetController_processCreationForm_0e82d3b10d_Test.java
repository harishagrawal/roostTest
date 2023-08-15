package org.springframework.samples.petclinic.owner;

import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

@ExtendWith(MockitoExtension.class)
public class PetController_processCreationForm_0e82d3b10d_Test {

    @Mock
    private Owner owner;

    @Mock
    private Pet pet;

    @Mock
    private BindingResult result;

    @Mock
    private ModelMap model;

    @Mock
    private OwnerRepository owners;

    @InjectMocks
    private PetController petController;

    @BeforeEach
    public void setUp() {
        when(owner.getPet(anyString(), anyBoolean())).thenReturn(null);
    }

    @Test
    public void testProcessCreationForm_duplicatePetName() {
        when(pet.getName()).thenReturn("Fido");
        when(pet.isNew()).thenReturn(true);
        when(owner.getPet("Fido", true)).thenReturn(new Pet());

        String view = petController.processCreationForm(owner, pet, result, model);
        verify(result).rejectValue("name", "duplicate", "already exists");
        assertEquals("pets/createOrUpdateForm", view);
    }

    @Test
    public void testProcessCreationForm_futureBirthDate() {
        when(pet.getBirthDate()).thenReturn(LocalDate.now().plusDays(1));

        String view = petController.processCreationForm(owner, pet, result, model);
        verify(result).rejectValue("birthDate", "typeMismatch.birthDate");
        assertEquals("pets/createOrUpdateForm", view);
    }

    @Test
    public void testProcessCreationForm_success() {
        when(pet.getName()).thenReturn("Fido");
        when(pet.isNew()).thenReturn(true);
        when(result.hasErrors()).thenReturn(false);

        String view = petController.processCreationForm(owner, pet, result, model);
        verify(owners).save(owner);
        assertEquals("redirect:/owners/{ownerId}", view);
    }
}
