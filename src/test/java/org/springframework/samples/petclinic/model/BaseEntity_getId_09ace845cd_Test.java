package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BaseEntity_getId_09ace845cd_Test {

    private BaseEntity baseEntity;

    @BeforeEach
    public void setUp() {
        this.baseEntity = new BaseEntity();
    }

    @Test
    public void testGetId_WhenIdIsNull() {
        assertNull(this.baseEntity.getId());
    }

    @Test
    public void testGetId_WhenIdIsNotNull() {
        Integer expectedId = 1;
        this.baseEntity.setId(expectedId);
        assertEquals(expectedId, this.baseEntity.getId());
    }
}
