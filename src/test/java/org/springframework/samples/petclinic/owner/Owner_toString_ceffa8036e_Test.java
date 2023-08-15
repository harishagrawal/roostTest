package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.style.ToStringCreator;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Owner_toString_ceffa8036e_Test {

    private Owner owner;

    @BeforeEach
    public void setup() {
        owner = new Owner();
        owner.setId(1);
        owner.setNew(false);
        owner.setLastName("Doe");
        owner.setFirstName("John");
        owner.setAddress("123 Street");
        owner.setCity("City");
        owner.setTelephone("1234567890");
    }

    @Test
    public void testToString() {
        String expected = new ToStringCreator(owner)
            .append("id", 1)
            .append("new", false)
            .append("lastName", "Doe")
            .append("firstName", "John")
            .append("address", "123 Street")
            .append("city", "City")
            .append("telephone", "1234567890")
            .toString();

        String actual = owner.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void testToStringWithNullValues() {
        owner = new Owner();
        owner.setId(2);
        owner.setNew(true);

        String expected = new ToStringCreator(owner)
            .append("id", 2)
            .append("new", true)
            .append("lastName", null)
            .append("firstName", null)
            .append("address", null)
            .append("city", null)
            .append("telephone", null)
            .toString();

        String actual = owner.toString();

        assertEquals(expected, actual);
    }
}
