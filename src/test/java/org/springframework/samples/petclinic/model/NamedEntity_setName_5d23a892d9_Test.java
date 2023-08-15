package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class NamedEntity_setName_5d23a892d9_Test {

    private NamedEntity namedEntity;

    @BeforeEach
    public void setup() {
        namedEntity = new NamedEntity();
    }

    @Test
    public void testSetName() {
        String name = "TestName";
        namedEntity.setName(name);
        assertEquals(name, namedEntity.getName());
    }

    @Test
    public void testSetName_NullValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            namedEntity.setName(null);
        });
    }
}
