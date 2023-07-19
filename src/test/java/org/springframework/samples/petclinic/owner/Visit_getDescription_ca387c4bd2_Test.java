package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.BaseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Visit_getDescription_ca387c4bd2_Test {

    private Visit visit;

    @BeforeEach
    public void setup() {
        this.visit = new Visit();
    }

    @Test
    public void testGetDescription_NullDescription() {
        this.visit.setDescription(null);
        String result = this.visit.getDescription();
        assertEquals(null, result, "Expected description to be null");
    }

    @Test
    public void testGetDescription_EmptyDescription() {
        this.visit.setDescription("");
        String result = this.visit.getDescription();
        assertEquals("", result, "Expected description to be empty");
    }

    @Test
    public void testGetDescription_ValidDescription() {
        String expectedDescription = "Regular Checkup";
        this.visit.setDescription(expectedDescription);
        String result = this.visit.getDescription();
        assertEquals(expectedDescription, result, "Expected description to match the set description");
    }
}
