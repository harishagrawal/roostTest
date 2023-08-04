package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Pet;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Owner2_getPet_a2da54c166_Test {

    @Mock
    private Owner owner;

    private Pet pet1;
    private Pet pet2;

    @BeforeEach
    public void setup() {
        pet1 = new Pet();
        pet1.setName("Fluffy");
        pet1.setNew(true);

        pet2 = new Pet();
        pet2.setName("Buffy");
        pet2.setNew(false);

        List<Pet> petList = Arrays.asList(pet1, pet2);

        when(owner.getPets()).thenReturn(petList);
    }

    @Test
    public void testGetPet_ignoreNewTrue() {
        Pet result = owner.getPet("Fluffy", true);
        assertNull(result, "Expected null as pet is new and ignoreNew is true");

        result = owner.getPet("Buffy", true);
        assertEquals(pet2, result, "Expected to get Buffy as pet is not new");
    }

    @Test
    public void testGetPet_ignoreNewFalse() {
        Pet result = owner.getPet("Fluffy", false);
        assertEquals(pet1, result, "Expected to get Fluffy as ignoreNew is false");

        result = owner.getPet("Buffy", false);
        assertEquals(pet2, result, "Expected to get Buffy as pet is not new");
    }

    @Test
    public void testGetPet_nonExistingPet() {
        Pet result = owner.getPet("NonExistent", true);
        assertNull(result, "Expected null as pet does not exist");

        result = owner.getPet("NonExistent", false);
        assertNull(result, "Expected null as pet does not exist");
    }
}
