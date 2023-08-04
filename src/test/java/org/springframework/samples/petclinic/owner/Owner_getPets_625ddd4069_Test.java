package org.springframework.samples.petclinic.owner;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Pet;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class Owner_getPets_625ddd4069_Test {

    @InjectMocks
    private Owner owner;

    @BeforeEach
    public void setup() {
        owner = new Owner();
    }

    @Test
    public void testGetPets_WhenPetsArePresent() {
        List<Pet> pets = new ArrayList<>();
        Pet pet1 = new Pet();
        Pet pet2 = new Pet();
        pets.add(pet1);
        pets.add(pet2);

        owner.setPets(pets);

        List<Pet> result = owner.getPets();
        assertEquals(2, result.size());
    }

    @Test
    public void testGetPets_WhenNoPetsArePresent() {
        List<Pet> pets = new ArrayList<>();

        owner.setPets(pets);

        List<Pet> result = owner.getPets();
        assertEquals(0, result.size());
    }
}
