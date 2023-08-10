package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Owner_setTelephone_df0456699c_Test {

    private Owner owner;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
        owner = new Owner();
    }

    @Test
    public void testSetTelephone_validNumber() {
        String validTelephone = "1234567890";
        owner.setTelephone(validTelephone);
        assertEquals(validTelephone, owner.getTelephone(), "Telephone number should be set correctly");
    }

    @Test
    public void testSetTelephone_emptyString() {
        String emptyTelephone = "";
        owner.setTelephone(emptyTelephone);
        assertEquals(emptyTelephone, owner.getTelephone(), "Empty telephone should be set correctly");
    }
}
