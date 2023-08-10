package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.core.style.ToStringCreator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Owner2_toString_2393b88875_Test {

    private Owner owner;

    @BeforeEach
    void setup() {
        owner = Mockito.mock(Owner.class);
        Mockito.when(owner.getId()).thenReturn(1);
        Mockito.when(owner.isNew()).thenReturn(true);
        Mockito.when(owner.getLastName()).thenReturn("Doe");
        Mockito.when(owner.getFirstName()).thenReturn("John");
        Mockito.when(owner.getAddress()).thenReturn("123 Main St");
        Mockito.when(owner.getCity()).thenReturn("Springfield");
        Mockito.when(owner.getTelephone()).thenReturn("123-456-7890");
    }

    @Test
    public void testToString() {
        String expected = new ToStringCreator(owner)
                .append("id", owner.getId())
                .append("new", owner.isNew())
                .append("lastName", owner.getLastName())
                .append("firstName", owner.getFirstName())
                .append("address", owner.getAddress())
                .append("city", owner.getCity())
                .append("telephone", owner.getTelephone())
                .toString();
        assertEquals(expected, owner.toString());
    }

    @Test
    public void testToStringWithNullFields() {
        Mockito.when(owner.getLastName()).thenReturn(null);
        Mockito.when(owner.getFirstName()).thenReturn(null);
        Mockito.when(owner.getAddress()).thenReturn(null);
        Mockito.when(owner.getCity()).thenReturn(null);
        Mockito.when(owner.getTelephone()).thenReturn(null);

        String expected = new ToStringCreator(owner)
                .append("id", owner.getId())
                .append("new", owner.isNew())
                .append("lastName", null)
                .append("firstName", null)
                .append("address", null)
                .append("city", null)
                .append("telephone", null)
                .toString();
        assertEquals(expected, owner.toString());
    }
}
