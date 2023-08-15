package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Pet;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class Owner2_addPet_b33ed0f86c_Test {

    @Mock
    Pet pet;

    @InjectMocks
    Owner owner;

    @BeforeEach
    void setUp() {
        owner.setPetsInternal(new HashSet<>());
    }

    @Test
    public void testAddPet_whenPetIsNew() {
        when(pet.isNew()).thenReturn(true);

        owner.addPet(pet);

        Set<Pet> pets = owner.getPets();
        assertTrue(pets.contains(pet));
    }

    @Test
    public void testAddPet_whenPetIsNotNew() {
        when(pet.isNew()).thenReturn(false);

        owner.addPet(pet);

        Set<Pet> pets = owner.getPets();
        assertFalse(pets.contains(pet));
    }
}
