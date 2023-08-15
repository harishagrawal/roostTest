package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseEntity_setTest_b8dd264bff_Test {

    private BaseEntity baseEntity;

    @BeforeEach
    public void setup() {
        baseEntity = new BaseEntity();
    }

    @Test
    public void testSetTest() {
        String testValue = "Test Value";
        baseEntity.setTest(testValue);
        assertEquals(testValue, baseEntity.getTest());
    }

    @Test
    public void testSetTestWithEmptyString() {
        String testValue = "";
        baseEntity.setTest(testValue);
        assertEquals(testValue, baseEntity.getTest());
    }

    @Test
    public void testSetTestWithNull() {
        baseEntity.setTest(null);
        assertEquals(null, baseEntity.getTest());
    }
}
