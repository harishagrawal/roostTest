package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.core.style.ToStringCreator;

public class Owner2_toString_2393b88875_Test {

    private Owner owner;

    @BeforeEach
    public void setUp() {
        owner = Mockito.mock(Owner.class);
    }

    @Test
    public void testToString() {
        Mockito.when(owner.getId()).thenReturn(1);
        Mockito.when(owner.isNew()).thenReturn(true);
        Mockito.when(owner.getLastName()).thenReturn("Doe");
        Mockito.when(owner.getFirstName()).thenReturn("John");
        Mockito.when(owner.getAddress()).thenReturn("123 Main St");
        Mockito.when(owner.getCity()).thenReturn("Springfield");
        Mockito.when(owner.getTelephone()).thenReturn("1234567890");

        String expected = new ToStringCreator(owner)
            .append("id", 1)
            .append("new", true)
            .append("lastName", "Doe")
            .append("firstName", "John")
            .append("address", "123 Main St")
            .append("city", "Springfield")
            .append("telephone", "1234567890")
            .toString();

        Assertions.assertEquals(expected, owner.toString());
    }

    @Test
    public void testToString_NullFields() {
        Mockito.when(owner.getId()).thenReturn(null);
        Mockito.when(owner.isNew()).thenReturn(false);
        Mockito.when(owner.getLastName()).thenReturn(null);
        Mockito.when(owner.getFirstName()).thenReturn(null);
        Mockito.when(owner.getAddress()).thenReturn(null);
        Mockito.when(owner.getCity()).thenReturn(null);
        Mockito.when(owner.getTelephone()).thenReturn(null);

        String expected = new ToStringCreator(owner)
            .append("id", null)
            .append("new", false)
            .append("lastName", null)
            .append("firstName", null)
            .append("address", null)
            .append("city", null)
            .append("telephone", null)
            .toString();

        Assertions.assertEquals(expected, owner.toString());
    }
}
