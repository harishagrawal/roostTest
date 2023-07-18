// Test generated by RoostGPT for test RoostTest using AI Type Open AI and AI Model gpt-4

package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.NamedEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NamedEntity_getName_4ad76af4d7_Test {

    private NamedEntity namedEntity;

    @BeforeEach
    public void setup() {
        namedEntity = new NamedEntity();
    }

    @Test
    public void testGetName_Success() {
        String expectedName = "Test Name";
        namedEntity.setName(expectedName);
        String actualName = namedEntity.getName();
        assertEquals(expectedName, actualName, "Expected name doesn't match with actual name");
    }

    @Test
    public void testGetName_Null() {
        String expectedName = null;
        namedEntity.setName(expectedName);
        String actualName = namedEntity.getName();
        assertEquals(expectedName, actualName, "Expected null name doesn't match with actual name");
    }
}
