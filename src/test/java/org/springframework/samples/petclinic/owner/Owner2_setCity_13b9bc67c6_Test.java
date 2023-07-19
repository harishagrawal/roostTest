package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Owner2_setCity_13b9bc67c6_Test {

    private Owner owner;

    @BeforeEach
    public void setup() {
        owner = new Owner();
    }

    @Test
    public void testSetCity_ValidCity() {
        String city = "New York";
        owner.setCity(city);
        assertEquals(city, owner.getCity());
    }

    @Test
    public void testSetCity_EmptyCity() {
        String city = "";
        owner.setCity(city);
        assertEquals(city, owner.getCity());
    }

    @Test
    public void testSetCity_NullCity() {
        String city = null;
        owner.setCity(city);
        assertEquals(city, owner.getCity());
    }

    @Test
    public void testSetCity_LongCity() {
        String city = "This is a very long city name that exceeds the normal length of a city name";
        owner.setCity(city);
        assertEquals(city, owner.getCity());
    }
}
