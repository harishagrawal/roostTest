package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Person;

import static org.junit.jupiter.api.Assertions.*;

class Owner2_setTelephone_df0456699c_Test {

    private Person person;

    @BeforeEach
    void setUp() {
        person = new Person();
    }

    @Test
    void testSetTelephone_success() {
        String telephone = "1234567890";
        person.setTelephone(telephone);
        assertEquals(telephone, person.getTelephone());
    }

    @Test
    void testSetTelephone_emptyString() {
        String telephone = "";
        person.setTelephone(telephone);
        assertEquals(telephone, person.getTelephone());
    }

    @Test
    void testSetTelephone_null() {
        String telephone = null;
        person.setTelephone(telephone);
        assertNull(person.getTelephone());
    }
}
