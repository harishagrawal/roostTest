package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseEntity_IdTest {

    private BaseEntity baseEntity;

    @BeforeEach
    public void setup() {
        baseEntity = new BaseEntity();
    }

    @Test
    public void testSetIdWithValidInteger() {
        Integer id = 1;
        baseEntity.setId(id);
        assertEquals(id, baseEntity.getId(), "The set id should match the get id");
    }

    @Test
    public void testSetIdWithNull() {
        baseEntity.setId(null);
        assertEquals(null, baseEntity.getId(), "The set id should match the get id even if it is null");
    }
}
