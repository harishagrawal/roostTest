package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class Pet_getType_5e69a8c7da_Test {

    @Mock
    private Pet pet;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetTypeSuccess() {
        PetType type = new PetType();
        type.setName("Dog");
        
        Mockito.when(pet.getType()).thenReturn(type);
        
        PetType actualType = pet.getType();
        
        Assertions.assertNotNull(actualType);
        Assertions.assertEquals("Dog", actualType.getName());
    }

    @Test
    public void testGetTypeFailure() {
        Mockito.when(pet.getType()).thenReturn(null);
        
        PetType actualType = pet.getType();
        
        Assertions.assertNull(actualType);
    }
}
