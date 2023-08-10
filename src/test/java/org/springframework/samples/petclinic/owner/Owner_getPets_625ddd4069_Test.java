package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Pet;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Owner_getPets_625ddd4069_Test {

    @Mock
    private Owner owner;

    @InjectMocks
    private Pet pet;

    private List<Pet> pets;

    @BeforeEach
    public void setup() {
        pets = new ArrayList<>();
        pets.add(pet);
        when(owner.getPets()).thenReturn(pets);
    }

    @Test
    public void testGetPetsSuccess() {
        List<Pet> testPets = owner.getPets();
        assertEquals(pets, testPets);
    }

    @Test
    public void testGetPetsFailure() {
        List<Pet> otherPets = new ArrayList<>();
        otherPets.add(Mockito.mock(Pet.class));
        assertEquals(otherPets, owner.getPets());
    }
}
