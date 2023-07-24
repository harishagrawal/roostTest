package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Owner_setCity_13b9bc67c6_Test {

    private Owner owner;

    @BeforeEach
    public void setup() {
        this.owner = new Owner();
    }

    @Test
    public void testSetCityWithValidCity() {
        String city = "New York";
        this.owner.setCity(city);
        assertEquals(city, this.owner.getCity());
    }

    @Test
    public void testSetCityWithNullCity() {
        assertThrows(NullPointerException.class, () -> this.owner.setCity(null));
    }
}
