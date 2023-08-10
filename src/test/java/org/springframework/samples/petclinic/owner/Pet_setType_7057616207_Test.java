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
        this.pet = new Pet();
    }

    @Test
    public void testSetType_success() {
        PetType type = new PetType();
        type.setName("Dog");
        this.pet.setType(type);
        assertEquals("Dog", this.pet.getType().getName());
    }

    @Test
    public void testSetType_null() {
        this.pet.setType(null);
        assertNull(this.pet.getType());
    }
}
