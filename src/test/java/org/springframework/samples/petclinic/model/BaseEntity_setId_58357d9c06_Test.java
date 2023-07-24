package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseEntity_setId_58357d9c06_Test {
    private BaseEntity baseEntity;

    @BeforeEach
    public void setup() {
        baseEntity = new BaseEntity();
    }

    @Test
    public void testSetIdPositiveNumber() {
        Integer expectedId = 5;
        baseEntity.setId(expectedId);

        assertEquals(expectedId, baseEntity.getId(), "The expected ID does not match the actual ID.");
    }

    @Test
    public void testSetIdNull() {
        baseEntity.setId(null);

        assertEquals(null, baseEntity.getId(), "The expected ID does not match the actual ID.");
    }
}
