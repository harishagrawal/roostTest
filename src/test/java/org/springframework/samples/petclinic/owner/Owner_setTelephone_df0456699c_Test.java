package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Person;
import org.springframework.util.Assert;

public class Owner_setTelephone_df0456699c_Test {

    private Person person;

    @BeforeEach
    public void setup() {
        this.person = new Person();
    }

    @Test
    public void testSetTelephone_validNumber() {
        String validTelephone = "1234567890";
        this.person.setTelephone(validTelephone);
        Assert.isTrue(this.person.getTelephone().equals(validTelephone), "Telephone number should be set correctly");
    }

    @Test
    public void testSetTelephone_emptyString() {
        String emptyTelephone = "";
        this.person.setTelephone(emptyTelephone);
        Assert.isTrue(this.person.getTelephone().equals(emptyTelephone), "Telephone number should be set correctly even if empty");
    }

    @Test
    public void testSetTelephone_null() {
        String nullTelephone = null;
        this.person.setTelephone(nullTelephone);
        Assert.isNull(this.person.getTelephone(), "Telephone number should be set correctly even if null");
    }

    @Test
    public void testSetTelephone_specialCharacters() {
        String specialCharTelephone = "#$%^&*()";
        this.person.setTelephone(specialCharTelephone);
        Assert.isTrue(this.person.getTelephone().equals(specialCharTelephone), "Telephone number should be set correctly even with special characters");
    }
}
