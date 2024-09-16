package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class Pet_getType_5e69a8c7da_Test {

    @Autowired
    private Pet pet;

    @MockBean
    private PetType petType;

    @Test
    public void testGetTypeSuccess() {
        when(pet.getType()).thenReturn(petType);
        PetType result = pet.getType();
        assertEquals(petType, result, "The returned type should match the mocked type");
    }

    @Test
    public void testGetTypeFailure() {
        when(pet.getType()).thenReturn(null);
        PetType result = pet.getType();
        assertEquals(null, result, "The returned type should be null as the mocked type is null");
    }
}
