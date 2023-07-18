package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BaseEntity_setId_58357d9c06_Test {

    private BaseEntity baseEntity;

    @BeforeEach
    public void setUp() {
        baseEntity = new BaseEntity();
    }

    @Test
    public void testSetId() {
        Integer id = 1;
        baseEntity.setId(id);
        assertEquals(id, baseEntity.getId(), "The id should be set correctly");
    }

    @Test
    public void testSetIdWithNull() {
        baseEntity.setId(null);
        assertNull(baseEntity.getId(), "The id should be null");
    }
}
