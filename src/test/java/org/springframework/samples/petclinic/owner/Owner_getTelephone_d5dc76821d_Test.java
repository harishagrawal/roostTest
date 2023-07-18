package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.samples.petclinic.model.Person;
import org.springframework.util.Assert;

import static org.mockito.Mockito.when;

public class Owner_getTelephone_d5dc76821d_Test {

    @Mock
    private Person person;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetTelephoneSuccess() {
        String expectedTelephone = "1234567890";
        when(person.getTelephone()).thenReturn(expectedTelephone);
        String actualTelephone = person.getTelephone();
        Assert.isTrue(expectedTelephone.equals(actualTelephone), "Expected and actual telephone numbers do not match");
    }

    @Test
    public void testGetTelephoneFailure() {
        String expectedTelephone = "1234567890";
        when(person.getTelephone()).thenReturn("0987654321");
        String actualTelephone = person.getTelephone();
        Assert.isTrue(!expectedTelephone.equals(actualTelephone), "Expected and actual telephone numbers should not match");
    }
}
