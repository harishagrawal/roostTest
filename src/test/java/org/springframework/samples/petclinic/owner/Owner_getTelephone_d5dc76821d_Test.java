package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Person;
import org.springframework.util.Assert;

@ExtendWith(MockitoExtension.class)
public class Owner_getTelephone_d5dc76821d_Test {

    @InjectMocks
    private Person person;

    @BeforeEach
    public void setup() {
        person = new Person();
        person.setTelephone("1234567890");
    }

    @Test
    public void testGetTelephone_Success() {
        String expectedTelephone = "1234567890";
        String actualTelephone = person.getTelephone();

        Assert.isTrue(expectedTelephone.equals(actualTelephone), "Telephone numbers should match");
    }

    @Test
    public void testGetTelephone_Failure() {
        String unexpectedTelephone = "0987654321";
        String actualTelephone = person.getTelephone();

        Assert.isTrue(!unexpectedTelephone.equals(actualTelephone), "Telephone numbers should not match");
    }
}
