package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.owner.Visit;

public class Visit_getDescription_ca387c4bd2_Test {

    private Visit visit;

    @BeforeEach
    public void setup() {
        visit = mock(Visit.class);
    }

    @Test
    public void testGetDescriptionSuccess() {
        String expectedDescription = "Regular Checkup";
        when(visit.getDescription()).thenReturn(expectedDescription);

        String actualDescription = visit.getDescription();

        assertEquals(expectedDescription, actualDescription, "Expected description does not match actual description");
    }

    @Test
    public void testGetDescriptionEmpty() {
        String expectedDescription = "";
        when(visit.getDescription()).thenReturn(expectedDescription);

        String actualDescription = visit.getDescription();

        assertEquals(expectedDescription, actualDescription, "Expected description does not match actual description");
    }
}
