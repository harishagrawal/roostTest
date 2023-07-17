package org.springframework.samples.petclinic.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.samples.petclinic.model.NamedEntity;

public class NamedEntity_getName_4ad76af4d7_Test {
    private NamedEntity namedEntity;

    @BeforeEach
    public void setup() {
        namedEntity = Mockito.mock(NamedEntity.class);
    }

    @Test
    public void testGetName_WithValidName() {
        String expectedName = "Test Name";
        Mockito.when(namedEntity.getName()).thenReturn(expectedName);
        String actualName = namedEntity.getName();
        assertEquals(expectedName, actualName, "Returned name should match the expected name");
    }

    @Test
    public void testGetName_WithNullName() {
        Mockito.when(namedEntity.getName()).thenReturn(null);
        String actualName = namedEntity.getName();
        assertEquals(null, actualName, "Returned name should be null when name is not set");
    }
}
