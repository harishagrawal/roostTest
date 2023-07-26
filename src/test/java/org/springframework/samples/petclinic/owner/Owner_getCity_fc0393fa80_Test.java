package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Person;
import org.springframework.util.Assert;

public class Owner_getCity_fc0393fa80_Test {

    private Person owner;

    @BeforeEach
    public void setup() {
        owner = new Person();
    }

    @Test
    public void testGetCity_WhenCityIsSet() {
        String expectedCity = "New York";
        owner.setCity(expectedCity);
        String actualCity = owner.getCity();
        Assert.isTrue(expectedCity.equals(actualCity), "Expected city does not match actual city");
    }

    @Test
    public void testGetCity_WhenCityIsNotSet() {
        String actualCity = owner.getCity();
        Assert.isNull(actualCity, "City should be null as it is not set");
    }
}
