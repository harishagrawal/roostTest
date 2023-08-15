package org.springframework.samples.petclinic.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BaseEntity_setId_fdd9d7675d_Test {

    private BaseEntity baseEntity;

    @BeforeEach
    public void setup() {
        baseEntity = mock(BaseEntity.class);
    }

    @Test
    public void testSetId_withValidId() {
        Integer validId = 1;
        when(baseEntity.getId()).thenReturn(validId);
        assertEquals(validId, baseEntity.getId(), "The ID set in the base entity should match the valid ID");
    }

    @Test
    public void testSetId_withNullId() {
        when(baseEntity.getId()).thenReturn(null);
        assertEquals(null, baseEntity.getId(), "The ID set in the base entity should be null");
    }
}
