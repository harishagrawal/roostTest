package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Person;
import org.springframework.core.style.ToStringCreator;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Owner2_toString_2393b88875_Test {

    private Person owner;

    @BeforeEach
    public void setup() {
        owner = new Person();
        owner.setId(1);
        owner.setNew(true);
        owner.setLastName("Smith");
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
        owner.setAddress(null);
        owner.setCity(null);
        owner.setTelephone(null);

        String expected = new ToStringCreator(owner)
            .append("id", owner.getId())
            .append("new", owner.isNew())
            .append("lastName", owner.getLastName())
            .append("firstName", owner.getFirstName())
            .append("address", null)
            .append("city", null)
            .append("telephone", null)
            .toString();

        assertEquals(expected, owner.toString());
    }
}
