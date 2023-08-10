package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class NamedEntity_setName_f5bd015150_Test {

    private NamedEntity namedEntity;

    @BeforeEach
    public void setup() {
        namedEntity = new NamedEntity();
    }

    @Test
    public void testSetName_Success() {
        String expectedName = "Test Name";
        namedEntity.setName(expectedName);
        Assertions.assertEquals(expectedName, namedEntity.getName());
    }

    @Test
    public void testSetName_Null() {
        String name = null;
        namedEntity.setName(name);
        Assertions.assertNull(namedEntity.getName());
    }

    @Test
    public void testSetName_Empty() {
        String name = "";
        namedEntity.setName(name);
        Assertions.assertEquals("", namedEntity.getName());
    }
}
