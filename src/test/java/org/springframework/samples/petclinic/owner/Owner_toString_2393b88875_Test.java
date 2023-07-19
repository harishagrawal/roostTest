package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.style.ToStringCreator;
import org.springframework.samples.petclinic.model.Person;

public class Owner_toString_2393b88875_Test {

    private Person person;

    @BeforeEach
    void setup() {
        person = new Person();
        person.setId(1);
        person.setNew(true);
        person.setLastName("Smith");
        person.setFirstName("John");
        person.setAddress("123 Main St");
        person.setCity("San Francisco");
        person.setTelephone("1234567890");
    }

    @Test
    public void testToString() {
        String expected = new ToStringCreator(person)
            .append("id", person.getId())
            .append("new", person.isNew())
            .append("lastName", person.getLastName())
            .append("firstName", person.getFirstName())
            .append("address", person.getAddress())
            .append("city", person.getCity())
            .append("telephone", person.getTelephone())
            .toString();

        String actual = person.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void testToStringWithNullValues() {
        person.setLastName(null);
        person.setFirstName(null);
        person.setAddress(null);
        person.setCity(null);
        person.setTelephone(null);

        String expected = new ToStringCreator(person)
            .append("id", person.getId())
            .append("new", person.isNew())
            .append("lastName", null)
            .append("firstName", null)
            .append("address", null)
            .append("city", null)
            .append("telephone", null)
            .toString();

        String actual = person.toString();

        assertEquals(expected, actual);
    }
}
