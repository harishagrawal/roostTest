package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BaseEntity_isNew_70b8047511_Test {

    private BaseEntity baseEntity;

    @BeforeEach
    public void setup() {
        baseEntity = new BaseEntity();
    }

    @Test
    public void testIsNew_withNullId() {
        baseEntity.setId(null);
        assertTrue(baseEntity.isNew(), "Newly created entity should be new");
    }

    @Test
    public void testIsNew_withNonNullId() {
        baseEntity.setId(1);
        assertFalse(baseEntity.isNew(), "Entity with id should not be new");
    }
}
