package org.springframework.samples.petclinic.model;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BaseEntity_isNew_70b8047511_Test {

    private BaseEntity baseEntity;

    @BeforeEach
    public void setup() {
        baseEntity = new BaseEntity();
    }

    @Test
    public void testIsNew_whenIdIsNull() {
        baseEntity.setId(null);
        assertTrue(baseEntity.isNew());
    }

    @Test
    public void testIsNew_whenIdIsNotNull() {
        baseEntity.setId(1);
        assertFalse(baseEntity.isNew());
    }
}
