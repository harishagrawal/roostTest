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
    public void testSetCity_ValidCity() {
        String validCity = "New York";
        this.person.setCity(validCity);
        assertEquals(validCity, this.person.getCity(), "The city should be set to New York");
    }

    @Test
    public void testSetCity_EmptyCity() {
        String emptyCity = "";
        this.person.setCity(emptyCity);
        assertEquals(emptyCity, this.person.getCity(), "The city should be set to an empty string");
    }

    @Test
    public void testSetCity_NullCity() {
        this.person.setCity(null);
        assertEquals(null, this.person.getCity(), "The city should be set to null");
    }
}
