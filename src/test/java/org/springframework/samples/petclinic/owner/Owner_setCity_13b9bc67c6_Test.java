package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Owner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Owner_setCity_13b9bc67c6_Test {

    private Owner owner;

    @BeforeEach
    public void setup() {
        owner = new Owner();
    }

    @Test
    public void testSetCity() {
        String testCity = "Test City";
        owner.setCity(testCity);
        assertEquals(testCity, owner.getCity(), "City should be set correctly");
    }

    @Test
    public void testSetCity_EmptyString() {
        String testCity = "";
        owner.setCity(testCity);
        assertEquals(testCity, owner.getCity(), "Empty city should be set correctly");
    }
}
