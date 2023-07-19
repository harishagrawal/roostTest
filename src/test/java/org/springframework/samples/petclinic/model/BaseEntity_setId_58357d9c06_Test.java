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
    public void testSetIdWithValidId() {
        Integer validId = 1;
        baseEntity.setId(validId);
        assertEquals(validId, baseEntity.getId(), "The ID set in the BaseEntity should match the ID retrieved from it.");
    }

    @Test
    public void testSetIdWithNullId() {
        baseEntity.setId(null);
        assertEquals(null, baseEntity.getId(), "The ID set in the BaseEntity should match the ID retrieved from it.");
    }
}
