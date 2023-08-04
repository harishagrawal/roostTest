package org.springframework.samples.petclinic.owner;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.samples.petclinic.model.Pet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

public class OwnerGetPetTest {

    private Owner owner;
    private Pet pet1;
    private Pet pet2;

    @Before
    public void setup() {
        owner = new Owner();
        pet1 = Mockito.mock(Pet.class);
        pet2 = Mockito.mock(Pet.class);

        when(pet1.getName()).thenReturn("Fido");
        when(pet2.getName()).thenReturn("Buddy");

        owner.addPet(pet1);
        owner.addPet(pet2);
    }

    @Test
    public void testGetPet() {
        Pet actualPet = owner.getPet("Fido", true);
        assertEquals(pet1, actualPet);
    }

    @Test
    public void testGetPet_ignoreNew() {
        when(pet1.isNew()).thenReturn(true);

        Pet actualPet = owner.getPet("Fido", true);
        assertNull(actualPet);
    }

    @Test
    public void testGetPet_nonExistingPet() {
        Pet actualPet = owner.getPet("NonExisting", true);
        assertNull(actualPet);
    }
}
