package org.springframework.samples.petclinic.owner;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Pet;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class Owner2_getPets_625ddd4069_Test {

    @InjectMocks
    private Owner owner;

    private List<Pet> pets;

    @BeforeEach
    public void setup() {
        owner = new Owner();
        pets = new ArrayList<>();
        pets.add(new Pet());
        pets.add(new Pet());
        owner.setPets(pets);
    }

    @Test
    public void testGetPets() {
        List<Pet> result = owner.getPets();
        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    public void testGetPetsWhenNoPets() {
        owner.setPets(new ArrayList<>());
        List<Pet> result = owner.getPets();
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }
}
