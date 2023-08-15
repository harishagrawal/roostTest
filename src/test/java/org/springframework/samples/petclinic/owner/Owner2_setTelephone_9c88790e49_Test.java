package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Person;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Owner2_setTelephone_9c88790e49_Test {

    private Person person;

    @BeforeEach
    public void setup() {
        person = new Person();
    }

    @Test
    public void testSetTelephone_validNumber() {
        String validTelephone = "1234567890";
        person.setTelephone(validTelephone);
        assertEquals(validTelephone, person.getTelephone());
    }

    @Test
    public void testSetTelephone_emptyString() {
        String emptyTelephone = "";
        person.setTelephone(emptyTelephone);
        assertEquals(emptyTelephone, person.getTelephone());
    }

}
