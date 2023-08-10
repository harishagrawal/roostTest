package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseEntity_setTest_5fff6a653b_Test {

    private BaseEntity baseEntity;

    @BeforeEach
    public void setUp() {
        baseEntity = new BaseEntity();
    }

    @Test
    public void testSetTestWithValidInput() {
        String testValue = "Test value";
        baseEntity.setTest(testValue);
        assertEquals(testValue, baseEntity.getTest(), "Test value should be set correctly");
    }

    @Test
    public void testSetTestWithNullInput() {
        baseEntity.setTest(null);
        assertEquals(null, baseEntity.getTest(), "Test value should be null");
    }
}
