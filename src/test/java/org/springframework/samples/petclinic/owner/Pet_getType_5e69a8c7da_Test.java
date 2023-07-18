package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.PetType;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Pet_getType_5e69a8c7da_Test {

    @Mock
    private PetType type;

    @InjectMocks
    private Pet pet;

    @BeforeEach
    public void setup() {
        when(type.getName()).thenReturn("Dog");
        pet.setType(type);
    }

    @Test
    public void testGetType() {
        PetType result = pet.getType();
        assertEquals(type, result);
    }

    @Test
    public void testGetTypeWithDifferentType() {
        PetType catType = new PetType();
        catType.setName("Cat");
        pet.setType(catType);
        PetType result = pet.getType();
        assertEquals(catType, result);
    }
}
