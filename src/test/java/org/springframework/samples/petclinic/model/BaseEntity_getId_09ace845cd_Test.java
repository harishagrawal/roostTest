package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class BaseEntity_getId_09ace845cd_Test {

    @InjectMocks
    BaseEntity baseEntity;

    @BeforeEach
    public void setup() {
        baseEntity = new BaseEntity();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetIdSuccess() {
        Integer expectedId = 1;
        baseEntity.setId(expectedId);
        Integer actualId = baseEntity.getId();
        Assertions.assertEquals(expectedId, actualId, "The expected ID does not match the actual ID");
    }

    @Test
    public void testGetIdFailure() {
        Integer unexpectedId = 2;
        baseEntity.setId(1);
        Integer actualId = baseEntity.getId();
        Assertions.assertNotEquals(unexpectedId, actualId, "The unexpected ID should not match the actual ID");
    }
}
