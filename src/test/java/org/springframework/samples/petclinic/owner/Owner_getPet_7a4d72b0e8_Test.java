package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
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
public class Owner_getPet_7a4d72b0e8_Test {

    @InjectMocks
    private Owner owner;

    @Mock
    private Pet pet1, pet2;

    @BeforeEach
    void setup() {
        List<Pet> petList = Arrays.asList(pet1, pet2);
        owner.getPets().addAll(petList);
        when(pet1.isNew()).thenReturn(false);
        when(pet1.getId()).thenReturn(1);
        when(pet2.isNew()).thenReturn(false);
        when(pet2.getId()).thenReturn(2);
    }

    @Test
    public void testGetPet_success() {
        Pet resultPet = owner.getPet(1);
        assertEquals(pet1, resultPet, "Expected and actual pets do not match");
    }

    @Test
    public void testGetPet_noMatch() {
        Pet resultPet = owner.getPet(3);
        assertNull(resultPet, "Expected null when no matching pet is found");
    }

    @Test
    public void testGetPet_newPet() {
        when(pet2.isNew()).thenReturn(true);
        Pet resultPet = owner.getPet(2);
        assertNull(resultPet, "Expected null when pet is new");
    }
}
