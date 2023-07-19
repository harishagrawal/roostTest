package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Owner2_setTelephone_df0456699c_Test {

    private Owner owner;

    @BeforeEach
    public void setUp() {
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
        assertNull(owner.getTelephone());
    }

    @Test
    public void testSetTelephone_specialCharacters() {
        String specialCharTelephone = "@#$$%^^&&**";
        owner.setTelephone(specialCharTelephone);
        assertEquals(specialCharTelephone, owner.getTelephone());
    }
}
