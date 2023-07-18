package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.util.Assert;

@SpringBootTest
public class Owner_toString_2393b88875_Test {

    @Test
    public void testToStringMethod() {
        Owner owner = Mockito.mock(Owner.class);

        Mockito.when(owner.getId()).thenReturn(1);
        Mockito.when(owner.isNew()).thenReturn(true);
        Mockito.when(owner.getLastName()).thenReturn("Doe");
        Mockito.when(owner.getFirstName()).thenReturn("John");
        Mockito.when(owner.getAddress()).thenReturn("123 Street");
        Mockito.when(owner.getCity()).thenReturn("City");
        Mockito.when(owner.getTelephone()).thenReturn("1234567890");

        String expectedOutput = "Owner@1{id=1, new=true, lastName='Doe', firstName='John', address='123 Street', city='City', telephone='1234567890'}";
        Assert.isTrue(owner.toString().equals(expectedOutput), "toString method is not working as expected");
    }

    @Test
    public void testToStringMethodWithEmptyValues() {
        Owner owner = Mockito.mock(Owner.class);

        Mockito.when(owner.getId()).thenReturn(0);
        Mockito.when(owner.isNew()).thenReturn(false);
        Mockito.when(owner.getLastName()).thenReturn("");
        Mockito.when(owner.getFirstName()).thenReturn("");
        Mockito.when(owner.getAddress()).thenReturn("");
        Mockito.when(owner.getCity()).thenReturn("");
        Mockito.when(owner.getTelephone()).thenReturn("");

        String expectedOutput = "Owner@1{id=0, new=false, lastName='', firstName='', address='', city='', telephone=''}";
        Assert.isTrue(owner.toString().equals(expectedOutput), "toString method is not working as expected with empty values");
    }
}
