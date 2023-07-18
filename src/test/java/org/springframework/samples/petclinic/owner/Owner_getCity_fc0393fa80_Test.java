package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Person;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class Owner_getCity_fc0393fa80_Test {

    @InjectMocks
    private Person person;

    @BeforeEach
    void setUp() {
        person = new Person();
    }

    @Test
    public void testGetCityWhenCityIsSet() {
        String expectedCity = "New York";
        person.setCity(expectedCity);
        String actualCity = person.getCity();
        assertEquals(expectedCity, actualCity, "City should match the set value");
    }

    @Test
    public void testGetCityWhenCityIsNotSet() {
        String actualCity = person.getCity();
        assertNull(actualCity, "City should be null when not set");
    }
}
