package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Person;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Owner_getTelephone_d5dc76821d_Test {

    private Person person;

    @BeforeEach
    public void setup() {
        person = new Person();
    }

    @Test
    public void testGetTelephoneWithValidNumber() {
        String validNumber = "1234567890";
        person.setTelephone(validNumber);
        assertEquals(validNumber, person.getTelephone());
    }

    @Test
    public void testGetTelephoneWithEmptyString() {
        person.setTelephone("");
        assertEquals("", person.getTelephone());
    }
}
