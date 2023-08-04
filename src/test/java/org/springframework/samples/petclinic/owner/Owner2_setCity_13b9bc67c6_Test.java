package org.springframework.samples.petclinic.owner;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.samples.petclinic.model.Owner;

public class Owner2_setCity_13b9bc67c6_Test {

    @Mock
    private Owner owner;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSetCityWithValidCityName() {
        String validCity = "New York";
        owner.setCity(validCity);
        Assert.assertEquals("City name did not match", validCity, owner.getCity());
    }

    @Test
    public void testSetCityWithEmptyCityName() {
        String emptyCity = "";
        owner.setCity(emptyCity);
        Assert.assertEquals("City name did not match", emptyCity, owner.getCity());
    }

    @Test
    public void testSetCityWithNullCityName() {
        String nullCity = null;
        owner.setCity(nullCity);
        Assert.assertEquals("City name did not match", nullCity, owner.getCity());
    }
}
