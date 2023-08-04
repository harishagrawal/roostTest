package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Person;
import org.springframework.util.Assert;

public class Owner2_getCity_fc0393fa80_Test {

    private Person person;

    @BeforeEach
    public void setUp() {
        person = new Person();
    }

    @Test
    public void testGetCity() {
        String city = "New York";
        person.setCity(city);
        Assert.isTrue(person.getCity().equals(city), () -> "City should be New York");
    }

    @Test
    public void testGetCityWhenCityIsNull() {
        Assert.isTrue(person.getCity() == null, () -> "City should be null");
    }
}
