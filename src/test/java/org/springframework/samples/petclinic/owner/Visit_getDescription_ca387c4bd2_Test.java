package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Visit;

public class Visit_getDescription_ca387c4bd2_Test {

    private Visit visit;

    @BeforeEach
    public void setUp() {
        this.visit = new Visit();
    }

    @Test
    public void testGetDescription_Null() {
        this.visit.setDescription(null);
        String actual = this.visit.getDescription();
        assertEquals(null, actual, "Expected description to be null");
    }

    @Test
    public void testGetDescription_NotNull() {
        String expected = "Test Description";
        this.visit.setDescription(expected);
        String actual = this.visit.getDescription();
        assertEquals(expected, actual, "Expected description to match the set value");
    }
}
