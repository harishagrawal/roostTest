package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class Pet_getType_5e69a8c7da_Test {

    @MockBean
    private Pet pet;

    private PetType expectedType;

    @BeforeEach
    public void setup() {
        expectedType = new PetType();
        expectedType.setName("Dog");
        when(pet.getType()).thenReturn(expectedType);
    }

    @Test
    public void testGetTypeSuccess() {
        PetType actualType = pet.getType();
        assertEquals(expectedType, actualType);
    }

    @Test
    public void testGetTypeFailure() {
        PetType wrongType = new PetType();
        wrongType.setName("Cat");
        PetType actualType = pet.getType();
        assertEquals(wrongType, actualType);
    }
}
