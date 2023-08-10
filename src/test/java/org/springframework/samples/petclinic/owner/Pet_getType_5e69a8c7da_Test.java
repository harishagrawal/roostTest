package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.PetType;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
public class Pet_getType_5e69a8c7da_Test {

    @InjectMocks
    Pet pet;

    @BeforeEach
    public void setup() {
        PetType type = new PetType();
        type.setName("Dog");
        pet.setType(type);
    }

    @Test
    public void testGetType() {
        PetType type = pet.getType();
        assertEquals("Dog", type.getName());
    }

    @Test
    public void testGetType_Null() {
        pet.setType(null);
        PetType type = pet.getType();
        assertNull(type);
    }
}
