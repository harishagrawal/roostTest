package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BaseEntity_setTest_5fff6a653b_Test {

    private BaseEntity baseEntity;

    @BeforeEach
    public void setUp() {
        baseEntity = new BaseEntity();
    }

    @Test
    public void testSetTest_validString() {
        String testValue = "validTest";
        baseEntity.setTest(testValue);
        assertEquals(testValue, baseEntity.getTest(), "The set value should match the get value");
    }

    @Test
    public void testSetTest_emptyString() {
        String testValue = "";
        baseEntity.setTest(testValue);
        assertEquals(testValue, baseEntity.getTest(), "The set value should match the get value even if it's empty");
    }

    @Test
    public void testSetTest_nullValue() {
        String testValue = null;
        baseEntity.setTest(testValue);
        assertNull(baseEntity.getTest(), "The get value should be null when the set value was null");
    }
}
