package org.springframework.samples.petclinic.owner;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

public class Owner2_getPet_a2da54c166_Test {

    private Owner owner;
    private Pet pet1;
    private Pet pet2;

    @BeforeEach
    public void setUp() {
        owner = new Owner();
        pet1 = Mockito.mock(Pet.class);
        pet2 = Mockito.mock(Pet.class);
        
        List<Pet> pets = new ArrayList<>();
        pets.add(pet1);
        pets.add(pet2);
        
        when(pet1.getName()).thenReturn("Fido");
        when(pet2.getName()).thenReturn("Buddy");
        
        owner.setPets(pets);
    }

    @Test
    public void testGetPetExists() {
        when(pet1.isNew()).thenReturn(false);
        Pet pet = owner.getPet("Fido", true);
        assertEquals(pet1, pet);
    }

    @Test
    public void testGetPetExistsButNewAndIgnored() {
        when(pet1.isNew()).thenReturn(true);
        Pet pet = owner.getPet("Fido", true);
        assertNull(pet);
    }

    @Test
    public void testGetPetExistsButNewAndNotIgnored() {
        when(pet1.isNew()).thenReturn(true);
        Pet pet = owner.getPet("Fido", false);
        assertEquals(pet1, pet);
    }

    @Test
    public void testGetPetDoesNotExist() {
        Pet pet = owner.getPet("NonExistentPet", true);
        assertNull(pet);
    }
}
