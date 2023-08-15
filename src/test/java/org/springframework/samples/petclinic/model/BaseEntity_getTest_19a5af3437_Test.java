package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class BaseEntity_getTest_19a5af3437_Test {

    @Mock
    private String test;

    @InjectMocks
    private BaseEntity baseEntity;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.test = "Test String";
    }

    @Test
    public void testGetTest_Success() {
        Assertions.assertEquals("Test String", baseEntity.getTest());
    }

    @Test
    public void testGetTest_Failure() {
        this.test = null;
        Assertions.assertNull(baseEntity.getTest());
    }
}
