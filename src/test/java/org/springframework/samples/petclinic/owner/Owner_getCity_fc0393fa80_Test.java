package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Person;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Owner_getCity_fc0393fa80_Test {

    private Person person;

    @BeforeEach
    void setUp() {
        person = new Person();
    }

    @Test
    public void testGetCity_WhenCityIsSet() {
        String expectedCity = "New York";
        person.setCity(expectedCity);
        String actualCity = person.getCity();
        assertEquals(expectedCity, actualCity, "City should be equal to the set value");
    }

    @Test
    public void testGetCity_WhenCityIsNotSet() {
        String actualCity = person.getCity();
        assertEquals(null, actualCity, "City should be null when not set");
    }
}
