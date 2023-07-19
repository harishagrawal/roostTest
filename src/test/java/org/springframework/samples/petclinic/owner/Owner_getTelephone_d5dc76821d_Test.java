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
    public void testGetTelephone_WithValidNumber() {
        String expectedTelephone = "1234567890";
        owner.setTelephone(expectedTelephone);

        String actualTelephone = owner.getTelephone();

        assertEquals(expectedTelephone, actualTelephone, "Returned telephone number does not match the expected value.");
    }

    @Test
    public void testGetTelephone_WithEmptyString() {
        String expectedTelephone = "";
        owner.setTelephone(expectedTelephone);

        String actualTelephone = owner.getTelephone();

        assertEquals(expectedTelephone, actualTelephone, "Returned telephone number does not match the expected value.");
    }
}
