package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Person;
import org.springframework.util.Assert;

public class Owner2_getCity_fc0393fa80_Test {

    private Owner2 owner2;

    @BeforeEach
    public void setup() {
        owner2 = new Owner2();
    }

    @Test
    public void testGetCity_whenCityIsSet() {
        String expectedCity = "New York";
        owner2.setCity(expectedCity);

        String actualCity = owner2.getCity();

        Assert.isTrue(expectedCity.equals(actualCity), "Expected city does not match actual city");
    }

    @Test
    public void testGetCity_whenCityIsNotSet() {
        String actualCity = owner2.getCity();

        Assert.isNull(actualCity, "City should be null as it is not set");
    }
}
