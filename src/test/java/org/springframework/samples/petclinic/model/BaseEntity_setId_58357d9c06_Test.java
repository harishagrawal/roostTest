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
    public void testSetId_Success() {
        Integer expectedId = 123;
        baseEntity.setId(expectedId);
        assertEquals(expectedId, baseEntity.getId(), "The ID set in the BaseEntity does not match the expected ID");
    }

    @Test
    public void testSetId_Null() {
        baseEntity.setId(null);
        assertEquals(null, baseEntity.getId(), "The ID set in the BaseEntity is not null");
    }
}
