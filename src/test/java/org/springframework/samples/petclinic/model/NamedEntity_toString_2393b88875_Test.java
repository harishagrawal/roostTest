package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NamedEntity_toString_2393b88875_Test {

    private NamedEntity namedEntity;

    @BeforeEach
    public void setup() {
        namedEntity = new NamedEntity();
    }

    @Test
    public void testToString_whenNameIsSet() {
        String expectedName = "Test Name";
        namedEntity.setName(expectedName);
        String actualName = namedEntity.toString();
        assertEquals(expectedName, actualName, "Expected name doesn't match with actual name");
    }

    @Test
    public void testToString_whenNameIsNotSet() {
        String expectedName = null;
        String actualName = namedEntity.toString();
        assertEquals(expectedName, actualName, "Expected name doesn't match with actual name");
    }
}
