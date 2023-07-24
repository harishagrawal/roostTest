package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Owner2_setCity_13b9bc67c6_Test {

    private Person person;

    @BeforeEach
    public void setup() {
        this.person = new Person();
    }

    @Test
    public void testSetCity_validCity() {
        String city = "New York";
        this.person.setCity(city);
        assertEquals(city, this.person.getCity());
    }

    @Test
    public void testSetCity_emptyCity() {
        String city = "";
        this.person.setCity(city);
        assertEquals(city, this.person.getCity());
    }

    @Test
    public void testSetCity_nullCity() {
        String city = null;
        this.person.setCity(city);
        assertEquals(city, this.person.getCity());
    }
}
