package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.PetType;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Pet_setType_7057616207_Test {

    private Pet pet;

    @BeforeEach
    public void setup() {
        pet = new Pet();
    }

    @Test
    public void testSetType_ValidType() {
        PetType type = new PetType();
        type.setName("Dog");
        pet.setType(type);

        assertEquals("Dog", pet.getType().getName());
    }

    @Test
    public void testSetType_NullType() {
        pet.setType(null);

        assertNull(pet.getType());
    }
}
