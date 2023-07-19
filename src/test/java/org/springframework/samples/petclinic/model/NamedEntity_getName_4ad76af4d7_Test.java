package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class NamedEntity_getName_4ad76af4d7_Test {

    @MockBean
    private NamedEntity namedEntity;

    @BeforeEach
    public void setUp() {
        when(namedEntity.getName()).thenReturn("Test Name");
    }

    @Test
    public void testGetName_success() {
        String name = namedEntity.getName();
        assertEquals("Test Name", name);
    }

    @Test
    public void testGetName_failure() {
        when(namedEntity.getName()).thenReturn(null);
        String name = namedEntity.getName();
        assertEquals(null, name);
    }
}
