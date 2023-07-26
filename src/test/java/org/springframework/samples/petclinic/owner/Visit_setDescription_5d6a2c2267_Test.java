package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.visit.Visit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Visit_setDescription_5d6a2c2267_Test {

    private Visit visit;

    @BeforeEach
    public void setup() {
        visit = new Visit();
    }

    @Test
    public void testSetDescription_Success() {
        String expectedDescription = "This is a test description";
        visit.setDescription(expectedDescription);
        assertEquals(expectedDescription, visit.getDescription());
    }

    @Test
    public void testSetDescription_Null() {
        String expectedDescription = null;
        visit.setDescription(expectedDescription);
        assertEquals(expectedDescription, visit.getDescription());
    }
}
