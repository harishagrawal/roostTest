package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class NamedEntity_setName_f5bd015150_Test {

    private NamedEntity namedEntity;

    @BeforeEach
    public void setup() {
        namedEntity = new NamedEntity();
    }

    @Test
    public void testSetName() {
        String name = "Test Name";
        namedEntity.setName(name);
        assertEquals(name, namedEntity.getName());
    }

    @Test
    public void testSetName_Null() {
        String name = null;
        namedEntity.setName(name);
        assertNull(namedEntity.getName());
    }

    @Test
    public void testSetName_Empty() {
        String name = "";
        namedEntity.setName(name);
        assertEquals(name, namedEntity.getName());
    }

    @Test
    public void testSetName_LongString() {
        String name = "This is a very long string that exceeds the maximum length for a name";
        namedEntity.setName(name);
        assertEquals(name, namedEntity.getName());
    }
}
