package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Person;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Owner2_getTelephone_d5dc76821d_Test {
    private Person person;

    @BeforeEach
    public void setup() {
        person = new Person();
    }

    @Test
    public void testGetTelephone_WithValidNumber() {
        String expectedTelephone = "1234567890";
        person.setTelephone(expectedTelephone);
        String actualTelephone = person.getTelephone();
        assertEquals(expectedTelephone, actualTelephone, "Expected telephone number does not match actual");
    }

    @Test
    public void testGetTelephone_WithEmptyString() {
        String expectedTelephone = "";
        person.setTelephone(expectedTelephone);
        String actualTelephone = person.getTelephone();
        assertEquals(expectedTelephone, actualTelephone, "Expected empty string but got something else");
    }
}
