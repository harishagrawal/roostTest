package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Person;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Owner2_getCity_e8cb16672d_Test {

    private Person person;

    @BeforeEach
    public void setup() {
        person = new Person();
    }

    @Test
    public void testGetCityWithNonNullCity() {
        String expectedCity = "New York";
        person.setCity(expectedCity);
        String actualCity = person.getCity();
        assertEquals(expectedCity, actualCity, "Expected city does not match actual city");
    }

    @Test
    public void testGetCityWithNullCity() {
        String expectedCity = null;
        person.setCity(expectedCity);
        String actualCity = person.getCity();
        assertEquals(expectedCity, actualCity, "Expected null city, but actual city is not null");
    }
}
