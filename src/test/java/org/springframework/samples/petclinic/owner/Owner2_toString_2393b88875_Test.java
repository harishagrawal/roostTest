package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.style.ToStringCreator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Owner2_toString_2393b88875_Test {

    private Owner2 owner;

    @BeforeEach
    public void setup() {
        owner = new Owner2();
        owner.setId(1);
        owner.setNew(true);
        owner.setLastName("Doe");
        owner.setFirstName("John");
        owner.setAddress("123 Street");
        owner.setCity("City");
        owner.setTelephone("1234567890");
    }

    @Test
    public void testToString() {
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
    public void testToStringWithNullValues() {
        owner = new Owner2();
        owner.setId(1);
        owner.setNew(true);
        owner.setLastName(null);
        owner.setFirstName(null);
        owner.setAddress(null);
        owner.setCity(null);
        owner.setTelephone(null);

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
}
