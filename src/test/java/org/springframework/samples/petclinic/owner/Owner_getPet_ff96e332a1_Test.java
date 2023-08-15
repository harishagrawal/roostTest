package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.samples.petclinic.model.Pet;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class Owner_getPet_ff96e332a1_Test {

    @Mock
    private Owner owner;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetPetSuccess() {
        Pet pet1 = new Pet();
        pet1.setName("Fido");
        pet1.setNew(false);

        Pet pet2 = new Pet();
        pet2.setName("Rex");
        pet2.setNew(true);

        List<Pet> pets = Arrays.asList(pet1, pet2);
        when(owner.getPets()).thenReturn(pets);

        Pet result = owner.getPet("Fido", false);
        assertNotNull(result);
        assertEquals("Fido", result.getName());
    }

    @Test
    public void testGetPetNotFound() {
        Pet pet1 = new Pet();
        pet1.setName("Fido");
        pet1.setNew(false);

        Pet pet2 = new Pet();
        pet2.setName("Rex");
        pet2.setNew(true);

        List<Pet> pets = Arrays.asList(pet1, pet2);
        when(owner.getPets()).thenReturn(pets);

        Pet result = owner.getPet("Buddy", false);
        assertNull(result);
    }

    @Test
    public void testGetPetIgnoreNew() {
        Pet pet1 = new Pet();
        pet1.setName("Fido");
        pet1.setNew(false);

        Pet pet2 = new Pet();
        pet2.setName("Rex");
        pet2.setNew(true);

        List<Pet> pets = Arrays.asList(pet1, pet2);
        when(owner.getPets()).thenReturn(pets);

        Pet result = owner.getPet("Rex", true);
        assertNull(result);
    }
}
