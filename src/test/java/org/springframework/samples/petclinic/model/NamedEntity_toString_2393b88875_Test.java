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
    public void testToString_withValidName() {
        String name = "Test Name";
        namedEntity.setName(name);
        String result = namedEntity.toString();
        assertEquals(name, result, "Expected and actual name should be the same");
    }

    @Test
    public void testToString_withNullName() {
        namedEntity.setName(null);
        String result = namedEntity.toString();
        assertEquals(null, result, "Expected and actual name should be the same");
    }
}
