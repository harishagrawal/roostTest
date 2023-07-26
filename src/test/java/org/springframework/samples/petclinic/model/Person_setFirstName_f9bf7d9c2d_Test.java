package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Person_setFirstName_f9bf7d9c2d_Test {

    @Test
    public void testSetFirstName() {
        Person person = new Person();
        String firstName = "John";
        person.setFirstName(firstName);
        assertEquals(firstName, person.getFirstName());
    }

    @Test
    public void testSetFirstNameWithNull() {
        Person person = new Person();
        String firstName = null;
        assertThrows(NullPointerException.class, () -> person.setFirstName(firstName));
    }
}
