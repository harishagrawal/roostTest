package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BaseEntity_getTest_cb622c11b2_Test {

    private BaseEntity baseEntity;

    @BeforeEach
    public void setup() {
        this.baseEntity = new BaseEntity();
    }

    @Test
    public void testGetTest_WhenTestValueIsSet() {
        String expectedValue = "TestValue";
        this.baseEntity.setTest(expectedValue);
        String actualValue = this.baseEntity.getTest();
        assertEquals(expectedValue, actualValue, "Expected value did not match the actual value");
    }

    @Test
    public void testGetTest_WhenTestValueIsNotSet() {
        String expectedValue = null;
        String actualValue = this.baseEntity.getTest();
        assertEquals(expectedValue, actualValue, "Expected value did not match the actual value");
    }
}
