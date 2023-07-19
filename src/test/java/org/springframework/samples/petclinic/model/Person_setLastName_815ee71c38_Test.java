package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class Person_setLastName_815ee71c38_Test {

    private Person person;

    @BeforeEach
    public void setup() {
        this.person = new Person();
    }

    @Test
    public void testSetLastName() {
        String lastName = "Smith";
        this.person.setLastName(lastName);
        assertEquals(lastName, this.person.getLastName());
    }

    @Test
    public void testSetLastName_Empty() {
        String lastName = "";
        this.person.setLastName(lastName);
        assertEquals(lastName, this.person.getLastName());
    }
}
