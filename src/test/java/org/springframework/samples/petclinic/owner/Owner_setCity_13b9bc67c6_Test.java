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
        String city = "New York";
        owner.setCity(city);
        assertEquals(city, owner.getCity());
    }

    @Test
    public void testSetCityWithEmptyString() {
        String city = "";
        owner.setCity(city);
        assertEquals(city, owner.getCity());
    }
}
