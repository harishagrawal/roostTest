package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Person;
import static org.junit.jupiter.api.Assertions.*;

public class Owner_setCity_13b9bc67c6_Test {

    private Person person;

    @BeforeEach
    public void setup() {
        person = new Person();
    }

    @Test
    public void testSetCity_ValidCity() {
        String city = "San Francisco";
        person.setCity(city);
        assertEquals(city, person.getCity());
    }

    @Test
    public void testSetCity_EmptyCity() {
        String city = "";
        person.setCity(city);
        assertEquals(city, person.getCity());
    }

    @Test
    public void testSetCity_NullCity() {
        String city = null;
        person.setCity(city);
        assertNull(person.getCity());
    }
}
