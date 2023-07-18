package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Person;
import org.springframework.util.Assert;

@ExtendWith(MockitoExtension.class)
public class Owner_getCity_fc0393fa80_Test {

    private Person owner;

    @BeforeEach
    public void setup() {
        owner = new Person();
    }

    @Test
    public void testGetCity_WhenCityIsSet() {
        String expectedCity = "New York";
        owner.setCity(expectedCity);
        Assert.isTrue(expectedCity.equals(owner.getCity()), "Expected city does not match actual city");
    }

    @Test
    public void testGetCity_WhenCityIsNotSet() {
        Assert.isTrue(owner.getCity() == null, "City should be null when not set");
    }

    @Test
    public void testGetCity_WhenCityIsEmpty() {
        owner.setCity("");
        Assert.isTrue("".equals(owner.getCity()), "City should be empty when set as empty");
    }
}
