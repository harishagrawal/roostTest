package org.springframework.samples.petclinic.owner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoJUnitRunner;
import org.springframework.samples.petclinic.model.Pet;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class Owner2_getPet_7f0beed2aa_Test {

    @InjectMocks
    private Owner owner;

    @Mock
    private Pet pet;

    private Set<Pet> pets;

    @Before
    public void setup() {
        owner = new Owner();
        pet = new Pet();
        pets = new HashSet<>();
        pets.add(pet);
        owner.setPetsInternal(pets);
    }

    @Test
    public void testGetPet_success() {
        when(pet.getName()).thenReturn("Fido");
        Pet result = owner.getPet("Fido");
        assertEquals(pet, result);
    }

    @Test
    public void testGetPet_petNotFound() {
        when(pet.getName()).thenReturn("Fido");
        Pet result = owner.getPet("Buster");
        assertNull(result);
    }
}
