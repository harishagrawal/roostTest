package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(MockitoExtension.class)
public class Pet_getType_5e69a8c7da_Test {

    @InjectMocks
    private Pet pet = new Pet();

    private PetType type = new PetType();

    @BeforeEach
    public void setup() {
        type.setName("Dog");
        pet.setType(type);
    }

    @Test
    public void testGetType_Success() {
        PetType actualType = pet.getType();
        assertEquals(type, actualType, "Expected and actual PetType should match");
    }

    @Test
    public void testGetType_Failure() {
        PetType newType = new PetType();
        newType.setName("Cat");
        PetType actualType = pet.getType();
        assertNotEquals(newType, actualType, "Expected and actual PetType should not match");
    }
}
