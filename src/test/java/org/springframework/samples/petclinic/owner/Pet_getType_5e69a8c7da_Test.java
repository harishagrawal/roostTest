package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class Pet_getType_5e69a8c7da_Test {

    @InjectMocks
    private Pet pet = new Pet();

    @Mock
    private PetType petType = new PetType();

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetTypeWhenTypeIsSet() {
        pet.setType(petType);
        assertEquals(petType, pet.getType(), "Expected pet type to match the set type");
    }

    @Test
    public void testGetTypeWhenTypeNotSet() {
        assertNull(pet.getType(), "Expected pet type to be null when not set");
    }
}
