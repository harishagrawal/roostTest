package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Person;
import org.springframework.util.Assert;

class Owner_setCity_13b9bc67c6_Test {

    private Person person;

    @BeforeEach
    void setUp() {
        person = new Person();
    }

    @Test
    void testSetCity_ValidCity() {
        String city = "New York";
        person.setCity(city);
        Assert.isTrue(person.getCity().equals(city), "Failed to set valid city");
    }

    @Test
    void testSetCity_EmptyCity() {
        String city = "";
        person.setCity(city);
        Assert.isTrue(person.getCity().equals(city), "Failed to set empty city");
    }

    @Test
    void testSetCity_NullCity() {
        String city = null;
        person.setCity(city);
        Assert.isTrue(person.getCity() == null, "Failed to set null city");
    }

    @Test
    void testSetCity_LongCityName() {
        String city = "SpringfieldSpringfieldSpringfieldSpringfieldSpringfieldSpringfield";
        person.setCity(city);
        Assert.isTrue(person.getCity().equals(city), "Failed to set long city name");
    }
}
