package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class Person_getFirstName_94e06d272a_Test {

    private Person person;

    @BeforeEach
    public void setup() {
        this.person = new Person();
        this.person.setFirstName("John");
    }

    @Test
    public void testGetFirstName() {
        String expected = "John";
        String actual = this.person.getFirstName();
        assertEquals(expected, actual, "Expected and actual first names do not match");
    }

    @Test
    public void testGetFirstName_Empty() {
        this.person.setFirstName("");
        String expected = "";
        String actual = this.person.getFirstName();
        assertEquals(expected, actual, "Expected empty but got a value");
    }

    @Test
    public void testGetFirstName_Null() {
        this.person.setFirstName(null);
        String actual = this.person.getFirstName();
        assertEquals(null, actual, "Expected null but got a value");
    }
}
