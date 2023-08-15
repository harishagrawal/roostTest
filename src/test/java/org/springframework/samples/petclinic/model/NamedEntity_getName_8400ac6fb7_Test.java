package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NamedEntity_getName_8400ac6fb7_Test {

    private NamedEntity namedEntity;

    @BeforeEach
    public void setUp() {
        namedEntity = new NamedEntity();
    }

    @Test
    public void testGetName_withNameSet() {
        namedEntity.setName("Test Name");
        String result = namedEntity.getName();
        assertEquals("Test Name", result);
    }

    @Test
    public void testGetName_withNoNameSet() {
        String result = namedEntity.getName();
        assertEquals(null, result);
    }
}
