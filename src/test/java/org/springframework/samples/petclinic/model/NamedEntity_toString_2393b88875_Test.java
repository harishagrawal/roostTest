package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class NamedEntity_toString_2393b88875_Test {

    @Mock
    private NamedEntity namedEntity;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testToString_withValidName() {
        when(namedEntity.getName()).thenReturn("TestName");
        String result = namedEntity.toString();
        assertEquals("TestName", result);
    }

    @Test
    public void testToString_withNullName() {
        when(namedEntity.getName()).thenReturn(null);
        String result = namedEntity.toString();
        assertEquals(null, result);
    }
}
