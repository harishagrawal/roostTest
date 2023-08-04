package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BaseEntity_getId_09ace845cd_Test {

    @InjectMocks
    BaseEntity baseEntity;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        baseEntity = new BaseEntity();
    }

    @Test
    public void testGetIdWhenIdIsNull() {
        assertNull(baseEntity.getId());
    }

    @Test
    public void testGetIdWhenIdIsNotNull() {
        Integer id = 123;
        baseEntity.setId(id);
        assertEquals(id, baseEntity.getId());
    }
}
