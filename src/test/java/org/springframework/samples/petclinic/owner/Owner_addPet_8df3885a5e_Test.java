package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class Owner_addPet_8df3885a5e_Test {

    @Mock
    private Pet pet;

    @InjectMocks
    private Owner owner;

    @BeforeEach
    public void setup() {
        Set<Pet> pets = new HashSet<>();
        when(pet.isNew()).thenReturn(true);
        pets.add(pet);
        owner.setPetsInternal(pets);
    }

    @Test
    public void testAddPetSuccessfully() {
        int initialSize = owner.getPets().size();
        Pet newPet = mock(Pet.class);
        when(newPet.isNew()).thenReturn(true);
        owner.addPet(newPet);
        int newSize = owner.getPets().size();
        assertEquals(initialSize + 1, newSize);
    }

    @Test
    public void testAddPetFailure() {
        int initialSize = owner.getPets().size();
        Pet existingPet = pet;
        when(existingPet.isNew()).thenReturn(false);
        owner.addPet(existingPet);
        int newSize = owner.getPets().size();
        assertEquals(initialSize, newSize);
    }
}
