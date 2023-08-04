package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.PetType;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Pet_setType_7057616207_Test {

    private Pet pet;

    @BeforeEach
    public void setUp() {
        this.pet = new Pet();
    }

    @Test
    public void testSetType() {
        PetType type = new PetType();
        type.setName("Dog");
        this.pet.setType(type);
        assertEquals(type, this.pet.getType());
    }

    @Test
    public void testSetType_Null() {
        this.pet.setType(null);
        assertNull(this.pet.getType());
    }
}
