package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.owner.Visit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Visit_getDescription_ca387c4bd2_Test {

    private Visit visit;

    @BeforeEach
    public void setup() {
        visit = new Visit();
    }

    @Test
    public void testGetDescription_WhenDescriptionIsSet() {
        String expectedDescription = "This is a test description";
        visit.setDescription(expectedDescription);
        String actualDescription = visit.getDescription();
        assertEquals(expectedDescription, actualDescription, "Expected description does not match actual description");
    }

    @Test
    public void testGetDescription_WhenDescriptionIsNotSet() {
        String expectedDescription = null; 
        String actualDescription = visit.getDescription();
        assertEquals(expectedDescription, actualDescription, "Expected description does not match actual description");
    }
}
