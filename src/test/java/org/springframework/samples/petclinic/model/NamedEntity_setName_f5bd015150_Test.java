package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NamedEntity_setName_f5bd015150_Test {

    private NamedEntity namedEntity;

    @BeforeEach
    public void setUp() {
        this.namedEntity = new NamedEntity();
    }

    @Test
    public void testSetName_ValidName() {
        String validName = "John Doe";
        this.namedEntity.setName(validName);
        assertEquals(validName, this.namedEntity.getName(), "The name should be set correctly.");
    }

    @Test
    public void testSetName_EmptyString() {
        String emptyName = "";
        this.namedEntity.setName(emptyName);
        assertEquals(emptyName, this.namedEntity.getName(), "The name should be set to an empty string.");
    }

    @Test
    public void testSetName_Null() {
        this.namedEntity.setName(null);
        assertEquals(null, this.namedEntity.getName(), "The name should be set to null.");
    }
}
