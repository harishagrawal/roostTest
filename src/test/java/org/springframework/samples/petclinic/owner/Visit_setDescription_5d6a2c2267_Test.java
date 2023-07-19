package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Visit_setDescription_5d6a2c2267_Test {

    private Visit visit;

    @BeforeEach
    public void setup() {
        visit = new Visit();
    }

    @Test
    public void testSetDescriptionSuccess() {
        String description = "This is a description";
        visit.setDescription(description);
        assertEquals(description, visit.getDescription());
    }

    @Test
    public void testSetDescriptionEmpty() {
        String description = "";
        visit.setDescription(description);
        assertEquals(description, visit.getDescription());
    }
}
