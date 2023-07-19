package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Owner_setTelephone_df0456699c_Test {

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
    public void testSetTelephone_nullValue() {
        String nullTelephone = null;
        owner.setTelephone(nullTelephone);
        assertNull(owner.getTelephone());
    }
}
