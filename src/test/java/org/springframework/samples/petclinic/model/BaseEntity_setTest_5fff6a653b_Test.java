package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseEntity_setTest_5fff6a653b_Test {

    private BaseEntity baseEntity;

    @BeforeEach
    public void setup() {
        this.baseEntity = new BaseEntity();
    }

    @Test
    public void testSetTestWithValidString() {
        String testValue = "testValue";
        this.baseEntity.setTest(testValue);
        assertEquals(testValue, this.baseEntity.getTest(), "The set method should set the value correctly.");
    }

    @Test
    public void testSetTestWithEmptyString() {
        String testValue = "";
        this.baseEntity.setTest(testValue);
        assertEquals(testValue, this.baseEntity.getTest(), "The set method should set the value correctly even if the string is empty.");
    }

    @Test
    public void testSetTestWithNull() {
        String testValue = null;
        this.baseEntity.setTest(testValue);
        assertEquals(testValue, this.baseEntity.getTest(), "The set method should handle null values correctly.");
    }
}
