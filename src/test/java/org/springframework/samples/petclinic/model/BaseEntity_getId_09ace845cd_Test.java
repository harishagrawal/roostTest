package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseEntity_getId_09ace845cd_Test {

    private BaseEntity baseEntity;

    @BeforeEach
    public void setup() {
        baseEntity = new BaseEntity();
    }

    @Test
    public void testGetIdSuccess() {
        Integer expectedId = 10;
        baseEntity.setId(expectedId);
        Integer actualId = baseEntity.getId();
        assertEquals(expectedId, actualId, "The expected ID does not match the actual ID.");
    }

    @Test
    public void testGetIdNull() {
        Integer actualId = baseEntity.getId();
        assertEquals(null, actualId, "The expected ID does not match the actual ID.");
    }
}
