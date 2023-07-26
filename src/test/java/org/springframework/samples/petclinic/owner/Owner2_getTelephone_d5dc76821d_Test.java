package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.samples.petclinic.model.Person;

public class Owner2_getTelephone_d5dc76821d_Test {
  
    private Person person;

    @BeforeEach
    public void setup() {
        person = Mockito.mock(Person.class);
    }

    @Test
    public void testGetTelephoneSuccess() {
        String expectedTelephone = "1234567890";
        Mockito.when(person.getTelephone()).thenReturn(expectedTelephone);
        String actualTelephone = person.getTelephone();
        assertEquals(expectedTelephone, actualTelephone);
    }

    @Test
    public void testGetTelephoneFailure() {
        String expectedTelephone = "1234567890";
        Mockito.when(person.getTelephone()).thenReturn("0987654321");
        String actualTelephone = person.getTelephone();
        assertNotEquals(expectedTelephone, actualTelephone);
    }
}
