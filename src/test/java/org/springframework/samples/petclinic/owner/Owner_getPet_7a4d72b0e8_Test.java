package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Pet;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class Owner_getPet_7a4d72b0e8_Test {

    @InjectMocks
    private Owner owner;

    @Mock
    private Pet pet1;

    @Mock
    private Pet pet2;

    @BeforeEach
    void setup() {
        when(pet1.isNew()).thenReturn(false);
        when(pet1.getId()).thenReturn(1);

        when(pet2.isNew()).thenReturn(false);
        when(pet2.getId()).thenReturn(2);

        owner.setPetsInternal(Arrays.asList(pet1, pet2));
    }

    @Test
    void testGetPet_ExistingId() {
        Pet pet = owner.getPet(1);
        assertNotNull(pet);
        assertEquals(1, pet.getId());
    }

    @Test
    void testGetPet_NonExistingId() {
        Pet pet = owner.getPet(3);
        assertNull(pet);
    }

    @Test
    void testGetPet_NewPet() {
        Pet newPet = mock(Pet.class);
        when(newPet.isNew()).thenReturn(true);
        when(newPet.getId()).thenReturn(3);
        owner.addPet(newPet);

        Pet pet = owner.getPet(3);
        assertNull(pet);
    }
}
