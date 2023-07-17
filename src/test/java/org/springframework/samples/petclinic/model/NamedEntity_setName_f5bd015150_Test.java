package org.springframework.samples.petclinic.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        String expectedName = "TestName";
        namedEntity.setName(expectedName);
        assertEquals(expectedName, namedEntity.getName(), "The name should be set correctly");
    }

    @Test
    public void testSetNameWithNull() {
        // TODO: Change the null to the expected value if null is not allowed
        String expectedName = null;
        namedEntity.setName(expectedName);
        assertEquals(expectedName, namedEntity.getName(), "The name should be set correctly even when it's null");
    }
}
