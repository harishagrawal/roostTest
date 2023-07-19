package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NamedEntity_toString_2393b88875_Test {

    private NamedEntity namedEntity;

    @BeforeEach
    public void setup() {
        namedEntity = Mockito.mock(NamedEntity.class);
    }

    @Test
    public void testToString_NameExists() {
        String expectedName = "Test Name";
        Mockito.when(namedEntity.getName()).thenReturn(expectedName);
        Mockito.when(namedEntity.toString()).thenCallRealMethod();
        String actualName = namedEntity.toString();
        assertEquals(expectedName, actualName);
    }

    @Test
    public void testToString_NameIsNull() {
        Mockito.when(namedEntity.getName()).thenReturn(null);
        Mockito.when(namedEntity.toString()).thenCallRealMethod();
        String actualName = namedEntity.toString();
        assertEquals(null, actualName);
    }
}
