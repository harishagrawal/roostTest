package org.springframework.samples.petclinic.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NamedEntity_setName_f5bd015150_Test {

    private NamedEntity namedEntity;

    @BeforeEach
    public void setUp() {
        namedEntity = new NamedEntity();
    }

    @Test
    public void testSetName() {
        String name = "TestName";
        namedEntity.setName(name);
        assertEquals(name, namedEntity.getName(), "The name set in NamedEntity does not match the expected value");
    }

    @Test
    public void testSetName_Null() {
        assertThrows(NullPointerException.class, () -> namedEntity.setName(null), "Expected setName() to throw NullPointerException for null name, but it didn't");
    }
}
