package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Person;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Owner_setTelephone_df0456699c_Test {

    private Person person;

    @BeforeEach
    public void setup() {
        this.person = new Person();
    }

    @Test
    public void testSetTelephone_Success() {
        String expectedTelephone = "1234567890";
        this.person.setTelephone(expectedTelephone);
        assertEquals(expectedTelephone, this.person.getTelephone());
    }

    @Test
    public void testSetTelephone_Null() {
        String expectedTelephone = null;
        this.person.setTelephone(expectedTelephone);
        assertEquals(expectedTelephone, this.person.getTelephone());
    }

    @Test
    public void testSetTelephone_EmptyString() {
        String expectedTelephone = "";
        this.person.setTelephone(expectedTelephone);
        assertEquals(expectedTelephone, this.person.getTelephone());
    }
}
