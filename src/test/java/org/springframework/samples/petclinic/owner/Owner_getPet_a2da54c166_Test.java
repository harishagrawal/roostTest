package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Pet;

import java.util.Arrays;

@ExtendWith(MockitoExtension.class)
public class Owner_getPet_a2da54c166_Test {

    private Owner owner;

    private Pet pet1;

    private Pet pet2;

    @BeforeEach
    void setup() {
        owner = mock(Owner.class);
        pet1 = mock(Pet.class);
        pet2 = mock(Pet.class);

        when(pet1.getName()).thenReturn("fluffy");
        when(pet2.getName()).thenReturn("fido");
        when(owner.getPets()).thenReturn(Arrays.asList(pet1, pet2));
    }

    @Test
    public void testGetPetSuccess() {
        when(pet1.isNew()).thenReturn(false);
        Pet result = owner.getPet("fluffy", true);
        assertEquals(pet1, result);
    }

    @Test
    public void testGetPetIgnoreNew() {
        when(pet1.isNew()).thenReturn(true);
        Pet result = owner.getPet("fluffy", true);
        assertNull(result);
    }

    @Test
    public void testGetPetNotFound() {
        Pet result = owner.getPet("notfound", true);
        assertNull(result);
    }

    @Test
    public void testGetPetCaseInsensitive() {
        when(pet2.isNew()).thenReturn(false);
        Pet result = owner.getPet("FIDO", true);
        assertEquals(pet2, result);
    }
}
