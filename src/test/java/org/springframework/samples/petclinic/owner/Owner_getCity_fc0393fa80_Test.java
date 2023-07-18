package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertEquals(expectedCity, actualCity, "Expected city to be New York but it was not");
    }

    @Test
    public void testGetCity_WhenCityIsNotSet() {
        String actualCity = owner.getCity();
        assertEquals(null, actualCity, "Expected city to be null but it was not");
    }
}
