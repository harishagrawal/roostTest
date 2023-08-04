package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.samples.petclinic.model.Person;
import org.springframework.util.Assert;

public class Owner2_setTelephone_df0456699c_Test {

    @Mock
    private Person person;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSetTelephoneSuccessful() {
        String testTelephone = "1234567890";
        person.setTelephone(testTelephone);
        Assert.notNull(person.getTelephone(), "Telephone should not be null");
        Assert.isTrue(person.getTelephone().equals(testTelephone), "Telephone should match the set value");
    }

    @Test
    public void testSetTelephoneNull() {
        person.setTelephone(null);
        Assert.isNull(person.getTelephone(), "Telephone should be null");
    }
}
