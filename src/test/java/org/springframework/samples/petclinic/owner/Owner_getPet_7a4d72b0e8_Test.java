package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Pet;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Owner_getPet_7a4d72b0e8_Test {

    @InjectMocks
    Owner owner;

    @Mock
    Pet pet1;

    @Mock
    Pet pet2;

    @BeforeEach
    void setUp() {
        owner = new Owner();
        pet1 = new Pet();
        pet2 = new Pet();
        when(pet1.getId()).thenReturn(1);
        when(pet2.getId()).thenReturn(2);
        List<Pet> petList = Arrays.asList(pet1, pet2);
        owner.setPetsInternal(petList);
    }

    @Test
    void testGetPet_success() {
        Pet pet = owner.getPet(1);
        assertNotNull(pet, "Expected non-null pet");
        assertEquals(1, pet.getId(), "Expected pet ID to match");
    }

    @Test
    void testGetPet_failure() {
        Pet pet = owner.getPet(3);
        assertNull(pet, "Expected null as pet with id 3 does not exist");
    }
}
