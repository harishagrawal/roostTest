package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Person;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Owner_getCity_fc0393fa80_Test {

    private Person person;

    @BeforeEach
    public void setup() {
        person = new Person();
    }

    @Test
    public void testGetCityWhenCityIsSet() {
        String expectedCity = "New York";
        person.setCity(expectedCity);
        String actualCity = person.getCity();
        assertEquals(expectedCity, actualCity, "Expected city does not match actual city");
    }

    @Test
    public void testGetCityWhenCityIsNotSet() {
        String expectedCity = null;
        String actualCity = person.getCity();
        assertEquals(expectedCity, actualCity, "Expected null as city is not set, but it's not null");
    }
}
