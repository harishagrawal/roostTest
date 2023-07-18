package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class BaseEntity_setId_58357d9c06_Test {

    private BaseEntity baseEntity;

    @BeforeEach
    public void setup() {
        baseEntity = new BaseEntity();
    }

    @Test
    public void testSetId_PositiveNumber() {
        Integer id = 1;
        baseEntity.setId(id);
        assertEquals(id, baseEntity.getId(), "The ID set in the BaseEntity does not match the expected ID.");
    }

    @Test
    public void testSetId_Null() {
        baseEntity.setId(null);
        assertEquals(null, baseEntity.getId(), "The ID set in the BaseEntity does not match the expected ID.");
    }

    // TODO: Add more test cases for different scenarios
}
