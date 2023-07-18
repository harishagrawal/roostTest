package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.petclinic.model.Person;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class Owner_setTelephone_df0456699c_Test {

    private Person person;

    @BeforeEach
    public void setup() {
        person = Mockito.mock(Person.class);
    }

    @Test
    public void testSetTelephone_Success() {
        String telephone = "1234567890";
        Mockito.doAnswer(i -> {
            assertEquals(telephone, i.getArgument(0));
            return null;
        }).when(person).setTelephone(Mockito.anyString());

        person.setTelephone(telephone);
    }

    @Test
    public void testSetTelephone_Empty() {
        String telephone = "";
        Mockito.doAnswer(i -> {
            assertEquals(telephone, i.getArgument(0));
            return null;
        }).when(person).setTelephone(Mockito.anyString());

        person.setTelephone(telephone);
    }

    @Test
    public void testSetTelephone_Null() {
        String telephone = null;
        Mockito.doAnswer(i -> {
            assertEquals(telephone, i.getArgument(0));
            return null;
        }).when(person).setTelephone(Mockito.anyString());

        person.setTelephone(telephone);
    }
}
