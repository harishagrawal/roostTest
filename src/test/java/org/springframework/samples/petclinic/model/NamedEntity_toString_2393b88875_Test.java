package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NamedEntity_toString_2393b88875_Test {

    private NamedEntity namedEntity;

    @BeforeEach
    void setUp() {
        namedEntity = new NamedEntity();
    }

    @Test
    void testToString_withValidName() {
        String name = "EntityName";
        namedEntity.setName(name);
        String result = namedEntity.toString();
        assertEquals(name, result, "Expected and actual names should be the same");
    }

    @Test
    void testToString_withNullName() {
        namedEntity.setName(null);
        String result = namedEntity.toString();
        assertNull(result, "Name should be null");
    }

    @Test
    void testToString_withEmptyName() {
        namedEntity.setName("");
        String result = namedEntity.toString();
        assertEquals("", result, "Name should be empty");
    }
}
