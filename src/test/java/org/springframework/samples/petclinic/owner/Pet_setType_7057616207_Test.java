package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.samples.petclinic.model.PetType;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Pet_setType_7057616207_Test {

    @Mock
    private Pet pet;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSetType() {
        PetType type = new PetType();
        type.setName("Dog");
        Mockito.doReturn(type).when(pet).getType();
        pet.setType(type);
        assertEquals("Dog", pet.getType().getName());
    }

    @Test
    public void testSetTypeNull() {
        Mockito.doReturn(null).when(pet).getType();
        pet.setType(null);
        assertNull(pet.getType());
    }
}
