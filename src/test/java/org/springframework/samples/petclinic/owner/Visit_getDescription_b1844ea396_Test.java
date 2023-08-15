package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Visit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Visit_getDescription_b1844ea396_Test {

    private Visit testVisit;

    @BeforeEach
    public void setup() {
        testVisit = new Visit();
        testVisit.setDescription("Test Description");
    }

    @Test
    public void testGetDescriptionSuccess() {
        String expectedDescription = "Test Description";
        String actualDescription = testVisit.getDescription();
        assertEquals(expectedDescription, actualDescription, "Expected and actual descriptions should match");
    }

    @Test
    public void testGetDescriptionFailure() {
        String unexpectedDescription = "Unexpected Description";
        String actualDescription = testVisit.getDescription();
        assertEquals(false, unexpectedDescription.equals(actualDescription), "Unexpected and actual descriptions should not match");
    }
}
