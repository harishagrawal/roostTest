package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BaseEntity_getTest_cb622c11b2_Test {

    private BaseEntity baseEntity;

    @BeforeEach
    public void setup() {
        baseEntity = new BaseEntity();
        baseEntity.setTest("test");
    }

    @Test
    public void testGetTest_Success() {
        String result = baseEntity.getTest();
        assertEquals("test", result);
    }

    @Test
    public void testGetTest_Failure() {
        baseEntity.setTest("wrong");
        String result = baseEntity.getTest();
        assertNotEquals("test", result);
    }
}
