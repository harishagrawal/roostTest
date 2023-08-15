package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BaseEntity_isNew_9b282f7a8e_Test {

    private BaseEntity baseEntity;

    @BeforeEach
    void setUp() {
        baseEntity = new BaseEntity();
    }

    @Test
    void testIsNew_withNullId() {
        baseEntity.setId(null);
        assertTrue(baseEntity.isNew());
    }

    @Test
    void testIsNew_withNonNullId() {
        baseEntity.setId(123);
        assertFalse(baseEntity.isNew());
    }
}
