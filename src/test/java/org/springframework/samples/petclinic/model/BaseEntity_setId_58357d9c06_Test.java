package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BaseEntity_setId_58357d9c06_Test {

    private BaseEntity baseEntity;

    @BeforeEach
    public void setup() {
        this.baseEntity = new BaseEntity();
    }

    @Test
    public void testSetIdSuccess() {
        Integer expectedId = 5;
        this.baseEntity.setId(expectedId);
        assertEquals(expectedId, this.baseEntity.getId());
    }

    @Test
    public void testSetIdNull() {
        this.baseEntity.setId(null);
        assertNull(this.baseEntity.getId());
    }
}
