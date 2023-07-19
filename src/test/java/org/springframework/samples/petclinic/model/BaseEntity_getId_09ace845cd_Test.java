package org.springframework.samples.petclinic.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BaseEntity_getId_09ace845cd_Test {

    private BaseEntity baseEntity;

    @BeforeEach
    public void setup() {
        baseEntity = new BaseEntity();
    }

    @Test
    public void testGetIdWhenIdIsNull() {
        baseEntity.setId(null);
        Integer id = baseEntity.getId();
        assertEquals(null, id, "The id should be null");
    }

    @Test
    public void testGetIdWhenIdIsNotNull() {
        baseEntity.setId(100);
        Integer id = baseEntity.getId();
        assertEquals(Integer.valueOf(100), id, "The id should be 100");
    }
}
