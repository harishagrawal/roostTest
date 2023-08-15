package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Owner_setTelephone_9c88790e49_Test {

    private Owner owner;

    @BeforeEach
    public void setup() {
        owner = new Owner();
    }

    @Test
    public void testSetTelephone_validNumber() {
        String validTelephone = "1234567890";
        owner.setTelephone(validTelephone);
        assertEquals(validTelephone, owner.getTelephone());
    }

    @Test
    public void testSetTelephone_emptyString() {
        String emptyTelephone = "";
        owner.setTelephone(emptyTelephone);
        assertEquals(emptyTelephone, owner.getTelephone());
    }

    @Test
    public void testSetTelephone_null() {
        String nullTelephone = null;
        owner.setTelephone(nullTelephone);
        assertEquals(nullTelephone, owner.getTelephone());
    }
}
