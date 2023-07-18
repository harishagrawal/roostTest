package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.PetType;

class Pet_setType_7057616207_Test {

    private Pet pet;

    @BeforeEach
    void setUp() {
        pet = new Pet();
    }

    @Test
    void testSetType() {
        PetType type = new PetType();
        type.setName("Dog");
        pet.setType(type);
        Assertions.assertEquals(type, pet.getType(), "Expected pet type to be Dog");
    }

    @Test
    void testSetType_Null() {
        pet.setType(null);
        Assertions.assertNull(pet.getType(), "Expected pet type to be null");
    }
}
