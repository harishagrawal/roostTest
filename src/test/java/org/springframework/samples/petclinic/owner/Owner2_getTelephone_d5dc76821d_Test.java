package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class Owner2_getTelephone_d5dc76821d_Test {

    @InjectMocks
    private Person person;

    @BeforeEach
    public void setUp() {
        this.person = new Person();
        this.person.setTelephone("1234567890");
    }

    @Test
    public void testGetTelephone_success() {
        String expectedTelephone = "1234567890";
        String actualTelephone = this.person.getTelephone();
        assertEquals(expectedTelephone, actualTelephone);
    }

    @Test
    public void testGetTelephone_failure() {
        String expectedTelephone = "0987654321";
        String actualTelephone = this.person.getTelephone();
        assertEquals(expectedTelephone, actualTelephone);
    }
}
