package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class Visit_setDescription_5d6a2c2267_Test {

    private Visit visit;

    @BeforeEach
    public void setup() {
        visit = new Visit();
    }

    @Test
    public void testSetDescription_ValidDescription() {
        String description = "This is a valid description";
        visit.setDescription(description);
        assertEquals(description, visit.getDescription(), "Expected and actual descriptions do not match.");
    }

    @Test
    public void testSetDescription_EmptyDescription() {
        String description = "";
        visit.setDescription(description);
        assertEquals(description, visit.getDescription(), "Expected and actual descriptions do not match.");
    }
}
