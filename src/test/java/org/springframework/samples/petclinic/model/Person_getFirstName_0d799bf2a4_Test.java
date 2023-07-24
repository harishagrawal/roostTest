package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class Person_getFirstName_0d799bf2a4_Test {

    @InjectMocks
    private Person person;

    @BeforeEach
    public void setup() {
        person = new Person();
        person.setFirstName("John");
    }

    @Test
    public void testGetFirstName_Success() {
        String expectedFirstName = "John";
        String actualFirstName = person.getFirstName();
        assertEquals(expectedFirstName, actualFirstName, "Expected and actual first names do not match");
    }

    @Test
    public void testGetFirstName_Failure() {
        String expectedFirstName = "Jane";
        String actualFirstName = person.getFirstName();
        assertEquals(expectedFirstName, actualFirstName, "Expected and actual first names do not match");
    }
}
