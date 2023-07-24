package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BaseEntity_getId_09ace845cd_Test {

    private BaseEntity baseEntity;

    @BeforeEach
    public void setup() {
        baseEntity = new BaseEntity();
    }

    @Test
    public void testGetIdWhenIdIsNotNull() {
        Integer expectedId = 1;
        baseEntity.setId(expectedId);

        Integer actualId = baseEntity.getId();

        assertEquals(expectedId, actualId, "The expected ID does not match the actual ID.");
    }

    @Test
    public void testGetIdWhenIdIsNull() {
        baseEntity.setId(null);

        Integer actualId = baseEntity.getId();

        assertNull(actualId, "The ID is not null.");
    }
}
