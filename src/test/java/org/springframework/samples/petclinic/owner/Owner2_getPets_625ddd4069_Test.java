package org.springframework.samples.petclinic.owner;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Pet;

@ExtendWith(MockitoExtension.class)
public class Owner2_getPets_625ddd4069_Test {

    @InjectMocks
    private Owner2 owner2;

    @Mock
    private List<Pet> pets;

    @BeforeEach
    public void setup() {
        owner2 = new Owner2();
        pets = new ArrayList<>();
        Pet pet1 = new Pet();
        pet1.setName("Bella");
        Pet pet2 = new Pet();
        pet2.setName("Max");
        pets.add(pet1);
        pets.add(pet2);
        owner2.setPets(pets);
    }

    @Test
    public void testGetPets() {
        List<Pet> result = owner2.getPets();
        Assertions.assertEquals(pets, result, "The returned list of pets is not as expected");
    }

    @Test
    public void testGetPets_EmptyList() {
        owner2.setPets(new ArrayList<>());
        List<Pet> result = owner2.getPets();
        Assertions.assertTrue(result.isEmpty(), "The returned list of pets is not empty as expected");
    }
}
