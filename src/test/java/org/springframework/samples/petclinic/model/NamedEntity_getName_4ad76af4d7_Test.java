package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class NamedEntity_getName_4ad76af4d7_Test {

    private NamedEntity namedEntity;

    @BeforeEach
    public void setUp() {
        this.namedEntity = new NamedEntity();
    }

    @Test
    public void testGetNameWhenNameIsSet() {
        String expectedName = "John";
        this.namedEntity.setName(expectedName);

        String actualName = this.namedEntity.getName();

        assertEquals(expectedName, actualName, "The name returned by getName() does not match the expected name.");
    }

    @Test
    public void testGetNameWhenNameIsNotSet() {
        String actualName = this.namedEntity.getName();

        assertEquals(null, actualName, "The name returned by getName() should be null when no name is set.");
    }
}
