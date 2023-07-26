package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

@SpringBootTest
public class Owner2_toString_2393b88875_Test {

    private Owner owner;

    @BeforeEach
    public void setup() {
        owner = new Owner();
        ReflectionTestUtils.setField(owner, "id", 1);
        ReflectionTestUtils.setField(owner, "new", false);
        ReflectionTestUtils.setField(owner, "lastName", "Smith");
        ReflectionTestUtils.setField(owner, "firstName", "John");
        ReflectionTestUtils.setField(owner, "address", "123 Street");
        ReflectionTestUtils.setField(owner, "city", "City");
        ReflectionTestUtils.setField(owner, "telephone", "1234567890");
    }

    @Test
    public void testToString() {
        String expected = "Owner@1[id=1,new=false,lastName='Smith',firstName='John',address='123 Street',city='City',telephone='1234567890']";
        Assertions.assertEquals(expected, owner.toString());
    }

    @Test
    public void testToString_NullFields() {
        Owner owner = new Owner();
        String expected = "Owner@1[id=null,new=false,lastName=null,firstName=null,address=null,city=null,telephone=null]";
        Assertions.assertEquals(expected, owner.toString());
    }
}
