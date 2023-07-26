package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Person;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Owner2_getCity_fc0393fa80_Test {

    private Person person;

    @BeforeEach
    public void setup() {
        this.person = new Person();
    }

    @Test
    public void testGetCity_WhenCityIsSet() {
        String expectedCity = "New York";
        this.person.setCity(expectedCity);
        String actualCity = this.person.getCity();
        assertEquals(expectedCity, actualCity, "Expected city does not match actual city");
    }

    @Test
    public void testGetCity_WhenCityIsNotSet() {
        String expectedCity = null;
        String actualCity = this.person.getCity();
        assertEquals(expectedCity, actualCity, "Expected city does not match actual city");
    }
}
