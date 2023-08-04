package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Person;
import org.springframework.util.Assert;

public class Owner2_getTelephone_d5dc76821d_Test {

    private Person person;

    @BeforeEach
    public void setup() {
        person = new Person();
    }

    @Test
    public void testGetTelephone() {
        String expectedTelephone = "1234567890";
        person.setTelephone(expectedTelephone);
        String actualTelephone = person.getTelephone();
        Assert.isTrue(expectedTelephone.equals(actualTelephone), "Telephone numbers do not match");
    }

    @Test
    public void testGetTelephoneWhenTelephoneIsNull() {
        String expectedTelephone = null;
        person.setTelephone(expectedTelephone);
        String actualTelephone = person.getTelephone();
        Assert.isTrue(expectedTelephone == actualTelephone, "Telephone numbers do not match");
    }
}
