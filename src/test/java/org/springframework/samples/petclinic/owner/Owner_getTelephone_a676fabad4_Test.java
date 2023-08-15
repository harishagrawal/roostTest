package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class Owner_getTelephone_a676fabad4_Test {

    @InjectMocks
    private Owner owner;

    @BeforeEach
    public void setUp() {
        owner = new Owner();
        owner.setTelephone("1234567890");
    }

    @Test
    public void testGetTelephoneSuccess() {
        String expected = "1234567890";
        String actual = owner.getTelephone();
        assertEquals(expected, actual, "Telephone should match the set value");
    }

    @Test
    public void testGetTelephoneFailure() {
        String unexpected = "0987654321";
        String actual = owner.getTelephone();
        assertEquals(false, unexpected.equals(actual), "Telephone should not match the unexpected value");
    }
}
