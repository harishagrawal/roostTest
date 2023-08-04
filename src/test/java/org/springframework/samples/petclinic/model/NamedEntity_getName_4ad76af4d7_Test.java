package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NamedEntity_getName_4ad76af4d7_Test {

    private NamedEntity namedEntity;

    @BeforeEach
    public void setup() {
        namedEntity = new NamedEntity();
    }

    @Test
    public void testGetName_WhenNameIsSet() {
        String expectedName = "TestName";
        namedEntity.setName(expectedName);
        String actualName = namedEntity.getName();
        assertEquals(expectedName, actualName, "The name returned by getName() method does not match the expected name");
    }

    @Test
    public void testGetName_WhenNameIsNotSet() {
        String actualName = namedEntity.getName();
        assertEquals(null, actualName, "The name returned by getName() method is not null when it should be");
    }
}
