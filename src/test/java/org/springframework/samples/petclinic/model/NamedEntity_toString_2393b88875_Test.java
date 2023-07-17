package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NamedEntity_toString_2393b88875_Test {

    private NamedEntity namedEntity;

    @BeforeEach
    public void setup() {
        namedEntity = new NamedEntity();
    }

    @Test
    public void testToString_NameExists() {
        namedEntity.setName("EntityName");
        assertEquals("EntityName", namedEntity.getName());
    }

    @Test
    public void testToString_NameDoesNotExist() {
        namedEntity.setName(null);
        assertEquals(null, namedEntity.getName());
    }
}
