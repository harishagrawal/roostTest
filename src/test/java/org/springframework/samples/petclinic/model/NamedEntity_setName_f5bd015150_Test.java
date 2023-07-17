package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NamedEntity_setName_f5bd015150_Test {

    private NamedEntity namedEntity;

    @BeforeEach
    public void setUp() {
        namedEntity = new NamedEntity();
    }

    @Test
    public void testSetName() {
        String name = "John Doe";
        namedEntity.setName(name);
        assertEquals(name, namedEntity.getName(), "The name set via setName() does not match the expected value.");
    }

    @Test
    public void testSetNameWithNull() {
        String name = null;
        namedEntity.setName(name);
        assertEquals(name, namedEntity.getName(), "The name set via setName() with null does not return null.");
    }
}
