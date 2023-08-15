package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.style.ToStringCreator;

public class Owner2_toString_ceffa8036e_Test {

    private Owner2 owner;
    private ToStringCreator mockToStringCreator;

    @BeforeEach
    public void setup() {
        owner = new Owner2();
        mockToStringCreator = mock(ToStringCreator.class);
    }

    @Test
    public void testToString() {
        owner.setId(1);
        owner.setNew(true);
        owner.setLastName("Doe");
        owner.setFirstName("John");
        owner.setAddress("123 Main St");
        owner.setCity("City");
        owner.setTelephone("1234567890");

        when(mockToStringCreator.append("id", owner.getId())).thenReturn(mockToStringCreator);
        when(mockToStringCreator.append("new", owner.isNew())).thenReturn(mockToStringCreator);
        when(mockToStringCreator.append("lastName", owner.getLastName())).thenReturn(mockToStringCreator);
        when(mockToStringCreator.append("firstName", owner.getFirstName())).thenReturn(mockToStringCreator);
        when(mockToStringCreator.append("address", owner.getAddress())).thenReturn(mockToStringCreator);
        when(mockToStringCreator.append("city", owner.getCity())).thenReturn(mockToStringCreator);
        when(mockToStringCreator.append("telephone", owner.getTelephone())).thenReturn(mockToStringCreator);
        when(mockToStringCreator.toString()).thenReturn("Owner2[id=1, new=true, lastName='Doe', firstName='John', address='123 Main St', city='City', telephone='1234567890']");

        String actual = owner.toString();
        String expected = "Owner2[id=1, new=true, lastName='Doe', firstName='John', address='123 Main St', city='City', telephone='1234567890']";

        assertEquals(expected, actual);
    }

    @Test
    public void testToStringWithNullValues() {
        owner.setId(1);
        owner.setNew(true);
        owner.setLastName(null);
        owner.setFirstName(null);
        owner.setAddress(null);
        owner.setCity(null);
        owner.setTelephone(null);

        when(mockToStringCreator.append("id", owner.getId())).thenReturn(mockToStringCreator);
        when(mockToStringCreator.append("new", owner.isNew())).thenReturn(mockToStringCreator);
        when(mockToStringCreator.append("lastName", owner.getLastName())).thenReturn(mockToStringCreator);
        when(mockToStringCreator.append("firstName", owner.getFirstName())).thenReturn(mockToStringCreator);
        when(mockToStringCreator.append("address", owner.getAddress())).thenReturn(mockToStringCreator);
        when(mockToStringCreator.append("city", owner.getCity())).thenReturn(mockToStringCreator);
        when(mockToStringCreator.append("telephone", owner.getTelephone())).thenReturn(mockToStringCreator);
        when(mockToStringCreator.toString()).thenReturn("Owner2[id=1, new=true, lastName=null, firstName=null, address=null, city=null, telephone=null]");

        String actual = owner.toString();
        String expected = "Owner2[id=1, new=true, lastName=null, firstName=null, address=null, city=null, telephone=null]";

        assertEquals(expected, actual);
    }
}
