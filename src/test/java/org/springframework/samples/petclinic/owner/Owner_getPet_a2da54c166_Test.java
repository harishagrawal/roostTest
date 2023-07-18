package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Pet;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Owner_getPet_a2da54c166_Test {

    @InjectMocks
    private Owner owner;

    @Mock
    private Pet pet1;

    @Mock
    private Pet pet2;

    @BeforeEach
    public void setup() {
        owner.setPetsInternal(Arrays.asList(pet1, pet2));
        when(pet1.getName()).thenReturn("Fido");
        when(pet2.getName()).thenReturn("Buddy");
        when(pet1.isNew()).thenReturn(false);
        when(pet2.isNew()).thenReturn(true);
    }

    @Test
    public void testGetPet_ExistingName_IgnoreNew() {
        Pet pet = owner.getPet("Fido", true);
        assertEquals(pet1, pet);
    }

    @Test
    public void testGetPet_ExistingName_DoNotIgnoreNew() {
        Pet pet = owner.getPet("Buddy", false);
        assertEquals(pet2, pet);
    }

    @Test
    public void testGetPet_NonExistingName() {
        Pet pet = owner.getPet("NonExisting", true);
        assertNull(pet);
    }

    @Test
    public void testGetPet_NewPet_IgnoreNew() {
        Pet pet = owner.getPet("Buddy", true);
        assertNull(pet);
    }
}
