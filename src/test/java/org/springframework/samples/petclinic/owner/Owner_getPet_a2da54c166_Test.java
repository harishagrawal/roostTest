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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Owner_getPet_a2da54c166_Test {

    @InjectMocks
    Owner owner = new Owner();

    @Mock
    Pet pet1 = new Pet();

    @Mock
    Pet pet2 = new Pet();

    @BeforeEach
    public void setup() {
        when(pet1.getName()).thenReturn("Fido");
        when(pet1.isNew()).thenReturn(false);
        when(pet2.getName()).thenReturn("Buddy");
        when(pet2.isNew()).thenReturn(true);
        List<Pet> petList = Arrays.asList(pet1, pet2);
        owner.setPetsInternal(petList);
    }

    @Test
    public void testGetPet() {
        Pet pet = owner.getPet("Fido", true);
        assertEquals(pet1, pet);

        pet = owner.getPet("Buddy", true);
        assertNull(pet);

        pet = owner.getPet("Buddy", false);
        assertEquals(pet2, pet);

        pet = owner.getPet("Unknown", true);
        assertNull(pet);
    }
}
