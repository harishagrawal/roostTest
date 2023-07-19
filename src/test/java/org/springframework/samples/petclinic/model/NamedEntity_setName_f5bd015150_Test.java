package org.springframework.samples.petclinic.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NamedEntity_setName_f5bd015150_Test {

    private NamedEntity namedEntity;

    @Before
    public void setUp() {
        this.namedEntity = new NamedEntity();
    }

    @Test
    public void testSetName_Success() {
        String expectedName = "Test Name";
        this.namedEntity.setName(expectedName);
        assertEquals("Name should be set correctly", expectedName, this.namedEntity.getName());
    }

    @Test
    public void testSetName_Null() {
        this.namedEntity.setName(null);
        assertEquals("Name should be null", null, this.namedEntity.getName());
    }
}
