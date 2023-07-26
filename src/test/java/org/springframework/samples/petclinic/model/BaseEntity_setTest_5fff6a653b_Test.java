package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

public class BaseEntity_setTest_5fff6a653b_Test {

    @Mock
    private BaseEntity baseEntity;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSetTest() {
        String testValue = "Test Value";
        when(baseEntity.getTest()).thenReturn(testValue);
        assertEquals(testValue, baseEntity.getTest());
    }

    @Test
    public void testSetTest_NullValue() {
        when(baseEntity.getTest()).thenReturn(null);
        assertNull(baseEntity.getTest());
    }
}
