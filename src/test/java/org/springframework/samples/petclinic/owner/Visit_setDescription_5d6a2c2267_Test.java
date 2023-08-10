package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class Visit_setDescription_5d6a2c2267_Test {

    @Test
    public void testSetDescription() {
        Visit visit = new Visit();
        String description = "This is a test description";
        visit.setDescription(description);
        Assert.isTrue(visit.getDescription().equals(description), "Expected and actual descriptions don't match");
    }

    @Test
    public void testSetDescriptionWithEmptyString() {
        Visit visit = new Visit();
        String description = "";
        visit.setDescription(description);
        Assert.isTrue(visit.getDescription().equals(description), "Expected and actual descriptions don't match");
    }

    @Test
    public void testSetDescriptionWithNull() {
        Visit visit = new Visit();
        String description = null;
        visit.setDescription(description);
        Assert.isTrue(visit.getDescription() == null, "Expected description to be null");
    }
}
