package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class NamedEntity_getName_4ad76af4d7_Test {

    @Mock
    NamedEntity namedEntity;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetName() {
        String expectedName = "Test Name";
        when(namedEntity.getName()).thenReturn(expectedName);
        String actualName = namedEntity.getName();
        assertEquals(expectedName, actualName, "The expected name does not match the actual name");
    }

    @Test
    public void testGetNameWhenNameIsNull() {
        when(namedEntity.getName()).thenReturn(null);
        String actualName = namedEntity.getName();
        assertEquals(null, actualName, "The expected name does not match the actual name");
    }
}
