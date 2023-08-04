package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Person;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Owner_getTelephone_d5dc76821d_Test {
    private Person person;

    @BeforeEach
    public void setup() {
        this.person = new Person();
    }

    @Test
    public void testGetTelephone_ValidNumber() {
        String validNumber = "1234567890";
        this.person.setTelephone(validNumber);
        String result = this.person.getTelephone();
        assertEquals(validNumber, result, "Telephone number should match");
    }

    @Test
    public void testGetTelephone_EmptyString() {
        String emptyString = "";
        this.person.setTelephone(emptyString);
        String result = this.person.getTelephone();
        assertEquals(emptyString, result, "Telephone number should be empty");
    }
}
