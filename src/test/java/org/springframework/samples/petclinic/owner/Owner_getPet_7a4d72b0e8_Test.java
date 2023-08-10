package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class Owner_getPet_7a4d72b0e8_Test {

    private Owner owner;
    private Pet pet1;
    private Pet pet2;

    @BeforeEach
    public void setup() {
        owner = new Owner();
        pet1 = mock(Pet.class);
        pet2 = mock(Pet.class);
    }

    @Test
    public void testGetPet_success() {
        when(pet1.isNew()).thenReturn(false);
        when(pet1.getId()).thenReturn(1);
        when(pet2.isNew()).thenReturn(false);
        when(pet2.getId()).thenReturn(2);
        owner.addPet(pet1);
        owner.addPet(pet2);

        Pet pet = owner.getPet("Pet1", false);
        assertNotNull(pet);
        assertEquals(1, pet.getId().intValue());
    }

    @Test
    public void testGetPet_notFound() {
        when(pet1.isNew()).thenReturn(false);
        when(pet1.getId()).thenReturn(1);
        when(pet2.isNew()).thenReturn(false);
        when(pet2.getId()).thenReturn(2);
        owner.addPet(pet1);
        owner.addPet(pet2);

        Pet pet = owner.getPet("Pet3", false);
        assertNull(pet);
    }

    @Test
    public void testGetPet_newPet() {
        when(pet1.isNew()).thenReturn(true);
        when(pet1.getId()).thenReturn(1);
        owner.addPet(pet1);

        Pet pet = owner.getPet("Pet1", true);
        assertNull(pet);
    }
}
