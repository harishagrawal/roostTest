package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class NamedEntity_toString_2393b88875_Test {

    @Mock
    private NamedEntity namedEntity;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testToString_NameExists() {
        String expectedName = "Test Name";
        when(namedEntity.getName()).thenReturn(expectedName);
        String actualName = namedEntity.toString();
        assertEquals(expectedName, actualName);
    }

    @Test
    void testToString_NameDoesNotExist() {
        String expectedName = null;
        when(namedEntity.getName()).thenReturn(expectedName);
        String actualName = namedEntity.toString();
        assertEquals(expectedName, actualName);
    }
}
