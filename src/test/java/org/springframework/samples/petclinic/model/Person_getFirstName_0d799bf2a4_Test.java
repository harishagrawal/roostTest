package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class Person_getFirstName_0d799bf2a4_Test {

    @MockBean
    private Person person;

    @BeforeEach
    public void setup() {
        when(person.getFirstName()).thenReturn("John");
    }

    @Test
    public void testGetFirstNameSuccess() {
        String firstName = person.getFirstName();
        assertEquals("John", firstName, "First name should be John");
    }

    @Test
    public void testGetFirstNameFailure() {
        String firstName = person.getFirstName();
        assertEquals("Jane", firstName, "First name should not be Jane");
    }
}
