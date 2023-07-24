package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.samples.petclinic.model.Person;

public class Owner_getTelephone_d5dc76821d_Test {

    @Test
    public void testGetTelephone_success() {
        Person person = new Person();
        person.setTelephone("1234567890");
        String expected = "1234567890";
        String actual = person.getTelephone();
        assertEquals(expected, actual, "Telephone number should be 1234567890");
    }

    @Test
    public void testGetTelephone_null() {
        Person person = new Person();
        person.setTelephone(null);
        String actual = person.getTelephone();
        assertEquals(null, actual, "Telephone number should be null");
    }
}
