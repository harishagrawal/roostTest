package org.springframework.samples.petclinic.owner;

import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.samples.petclinic.model.Pet;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

public class Owner_getPet_7a4d72b0e8_Test {

    @InjectMocks
    Owner owner;

    @Mock
    Pet pet1;

    @Mock
    Pet pet2;

    @BeforeEach
    public void setup() {
        owner = new Owner();
        pet1 = new Pet();
        pet2 = new Pet();
        MockitoAnnotations.initMocks(this);
        when(pet1.isNew()).thenReturn(false);
        when(pet1.getId()).thenReturn(1);
        when(pet2.isNew()).thenReturn(false);
        when(pet2.getId()).thenReturn(2);
        owner.setPetsInternal(Arrays.asList(pet1, pet2));
    }

    @Test
    public void testGetPet_ExistingId() {
        assertEquals(pet1, owner.getPet(1));
        assertEquals(pet2, owner.getPet(2));
    }

    @Test
    public void testGetPet_NonExistingId() {
        assertNull(owner.getPet(3));
    }

    @Test
    public void testGetPet_EmptyPets() {
        owner.setPetsInternal(Collections.emptyList());
        assertNull(owner.getPet(1));
    }
}
