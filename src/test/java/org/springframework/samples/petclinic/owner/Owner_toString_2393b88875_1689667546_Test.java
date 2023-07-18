package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.style.ToStringCreator;
import org.springframework.samples.petclinic.model.Person;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Owner_toString_2393b88875_1689667546_Test {

    private Owner owner;

    @BeforeEach
    public void setup() {
        owner = new Owner();
        owner.setId(1);
        owner.setNew(false);
        owner.setLastName("Doe");
        owner.setFirstName("John");
        owner.setAddress("123 Main Street");
        owner.setCity("New York");
        owner.setTelephone("1234567890");
    }

    @Test
    public void testToStringMethod() {
        String expected = new ToStringCreator(owner)
                .append("id", owner.getId())
                .append("new", owner.isNew())
                .append("lastName", owner.getLastName())
                .append("firstName", owner.getFirstName())
                .append("address", owner.getAddress())
                .append("city", owner.getCity())
                .append("telephone", owner.getTelephone())
                .toString();
        assertEquals(expected, owner.toString());
    }

    @Test
    public void testToStringMethodWithEmptyFields() {
        Owner emptyOwner = new Owner();
        String expected = new ToStringCreator(emptyOwner)
                .append("id", null)
                .append("new", false)
                .append("lastName", null)
                .append("firstName", null)
                .append("address", null)
                .append("city", null)
                .append("telephone", null)
                .toString();
        assertEquals(expected, emptyOwner.toString());
    }
}
