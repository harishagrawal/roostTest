package org.springframework.samples.petclinic.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NamedEntity_getName_4ad76af4d7_Test {

    private NamedEntity namedEntity;

    @BeforeEach
    public void setup() {
        namedEntity = new NamedEntity();
    }

    @Test
    public void testGetName() {
        namedEntity.setName("TestName");
        String actual = namedEntity.getName();
        String expected = "TestName";
        assertEquals(expected, actual);
    }

    @Test
    public void testGetNameWithEmptyString() {
        namedEntity.setName("");
        String actual = namedEntity.getName();
        String expected = "";
        assertEquals(expected, actual);
    }

    @Test
    public void testGetNameWithNull() {
        namedEntity.setName(null);
        String actual = namedEntity.getName();
        String expected = null;
        assertEquals(expected, actual);
    }
}
