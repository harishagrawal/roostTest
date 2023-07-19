package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class NamedEntity_toString_2393b88875_Test {

    private NamedEntity namedEntity;

    @BeforeEach
    public void setUp() {
        this.namedEntity = Mockito.mock(NamedEntity.class);
    }

    @Test
    public void testToString_whenNameIsNotNull() {
        String expectedName = "Test Name";
        Mockito.when(this.namedEntity.getName()).thenReturn(expectedName);
        String actualName = this.namedEntity.toString();
        assertEquals(expectedName, actualName, "Expected name doesn't match with actual name");
    }

    @Test
    public void testToString_whenNameIsNull() {
        Mockito.when(this.namedEntity.getName()).thenReturn(null);
        String actualName = this.namedEntity.toString();
        assertNull(actualName, "Name should be null");
    }
}
