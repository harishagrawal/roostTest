package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Person;
import org.springframework.util.Assert;

public class Owner_setTelephone_df0456699c_Test {

    private Person owner;

    @BeforeEach
    public void setup() {
        owner = new Person();
    }

    @Test
    public void testSetTelephone_validNumber() {
        String validTelephone = "1234567890";
        owner.setTelephone(validTelephone);
        Assert.isTrue(owner.getTelephone().equals(validTelephone), "Telephone number should match the set value");
    }

    @Test
    public void testSetTelephone_emptyString() {
        String emptyTelephone = "";
        owner.setTelephone(emptyTelephone);
        Assert.isTrue(owner.getTelephone().equals(emptyTelephone), "Telephone number should match the set value");
    }

    @Test
    public void testSetTelephone_nullValue() {
        String nullTelephone = null;
        owner.setTelephone(nullTelephone);
        Assert.isTrue(owner.getTelephone() == null, "Telephone number should be null");
    }

    @Test
    public void testSetTelephone_invalidNumber() {
        String invalidTelephone = "invalidNumber";
        String expectedTelephone = "invalidNumber";
        owner.setTelephone(invalidTelephone);
        Assert.isTrue(owner.getTelephone().equals(expectedTelephone), "Telephone number should match the expected value after validation");
    }
}
