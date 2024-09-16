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
        assertTrue(baseEntity.isNew(), "Expected isNew() to return true when id is null");
    }

    @Test
    public void testIsNew_withNonNullId() {
        baseEntity.setId(1);
        assertFalse(baseEntity.isNew(), "Expected isNew() to return false when id is non-null");
    }
}
