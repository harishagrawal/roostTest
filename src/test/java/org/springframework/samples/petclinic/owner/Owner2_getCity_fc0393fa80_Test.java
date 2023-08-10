package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Person;
import org.springframework.util.Assert;

public class Owner2_getCity_fc0393fa80_Test {

    private Person person;

    @BeforeEach
    public void setup() {
        person = new Person();
    }

    @Test
    public void testGetCity_WhenCityIsSet() {
        String expectedCity = "New York";
        person.setCity(expectedCity);
        String actualCity = person.getCity();
        Assert.isTrue(expectedCity.equals(actualCity), "Expected city does not match actual city");
    }

    @Test
    public void testGetCity_WhenCityIsNotSet() {
        String actualCity = person.getCity();
        Assert.isNull(actualCity, "City should be null as it is not set");
    }
}
