package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Person;
import org.springframework.util.Assert;

public class Owner2_setCity_9dae12ad63_Test {

    private Person person;

    @BeforeEach
    public void setup() {
        person = new Person();
    }

    @Test
    public void testSetCity_ValidCity() {
        String city = "New York";
        person.setCity(city);
        Assert.isTrue(person.getCity().equals(city), "City should be set correctly");
    }

    @Test
    public void testSetCity_EmptyString() {
        String city = "";
        person.setCity(city);
        Assert.isTrue(person.getCity().equals(city), "City should be set correctly even if the input is an empty string");
    }

    @Test
    public void testSetCity_NullCity() {
        String city = null;
        person.setCity(city);
        Assert.isNull(person.getCity(), "City should be null when the input is null");
    }
}
