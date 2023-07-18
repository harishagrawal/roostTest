package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Owner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Owner_getTelephone_d5dc76821d_Test {

    private Owner owner;

    @BeforeEach
    public void setup() {
        owner = new Owner();
    }

    @Test
    public void testGetTelephone() {
        String expectedTelephone = "1234567890";
        owner.setTelephone(expectedTelephone);
        String actualTelephone = owner.getTelephone();
        assertEquals(expectedTelephone, actualTelephone, "Telephone numbers should match");
    }

    @Test
    public void testGetTelephoneWhenTelephoneIsNull() {
        String actualTelephone = owner.getTelephone();
        assertEquals(null, actualTelephone, "Telephone should be null");
    }
}
