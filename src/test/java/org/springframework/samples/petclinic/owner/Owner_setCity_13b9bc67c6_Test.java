package org.springframework.samples.petclinic.owner;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.petclinic.model.Person;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Owner_setCity_13b9bc67c6_Test {
    
    @Test
    public void testSetCity() {
        Person person = new Person();
        person.setCity("New York");
        Assert.assertEquals("New York", person.getCity());
    }

    @Test
    public void testSetCityWithNull() {
        Person person = new Person();
        person.setCity(null);
        Assert.assertNull(person.getCity());
    }

    @Test
    public void testSetCityWithEmptyString() {
        Person person = new Person();
        person.setCity("");
        Assert.assertEquals("", person.getCity());
    }
}
