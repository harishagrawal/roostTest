package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.PetType;

public class Pet_getType_3e60e43fbc_Test {

    private Pet pet;

    @BeforeEach
    public void setup() {
        pet = new Pet();
    }

    @Test
    public void testGetTypeWhenTypeIsNotNull() {
        PetType type = new PetType();
        type.setName("Dog");
        pet.setType(type);
        Assertions.assertEquals(type, pet.getType(), "Pet type should be Dog");
    }

    @Test
    public void testGetTypeWhenTypeIsNull() {
        pet.setType(null);
        Assertions.assertNull(pet.getType(), "Pet type should be null");
    }
}
