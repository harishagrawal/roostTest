package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Pet;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Owner2_getPet_7a4d72b0e8_Test {

    @InjectMocks
    private Owner owner = new Owner();

    @Mock
    private Pet pet1 = new Pet();

    @Mock
    private Pet pet2 = new Pet();

    @BeforeEach
    void setup() {
        List<Pet> petList = new ArrayList<>();
        when(pet1.getId()).thenReturn(1);
        when(pet1.isNew()).thenReturn(false);
        petList.add(pet1);

        when(pet2.getId()).thenReturn(2);
        when(pet2.isNew()).thenReturn(false);
        petList.add(pet2);

        owner.setPetsInternal(petList);
    }

    @Test
    void testGetPet_success() {
        Pet foundPet = owner.getPet("pet1", false);
        assertNotNull(foundPet);
        assertEquals(1, foundPet.getId());
    }

    @Test
    void testGetPet_petDoesNotExist() {
        Pet foundPet = owner.getPet("pet3", false);
        assertNull(foundPet);
    }
}
