package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Person;

import static org.junit.jupiter.api.Assertions.*;

class Owner2_setTelephone_df0456699c_Test {

    private Person person;

    @BeforeEach
    void setUp() {
        this.person = new Person();
    }

    @Test
    void testSetTelephone_validNumber() {
        String validNumber = "1234567890";
        this.person.setTelephone(validNumber);
        assertEquals(validNumber, this.person.getTelephone());
    }

    @Test
    void testSetTelephone_invalidNumber() {
        String invalidNumber = "12345ab";
        this.person.setTelephone(invalidNumber);
        assertNotEquals(invalidNumber, this.person.getTelephone());
    }

    @Test
    void testSetTelephone_nullNumber() {
        String nullNumber = null;
        this.person.setTelephone(nullNumber);
        assertNull(this.person.getTelephone());
    }
}
