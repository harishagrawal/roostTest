package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class PetTypeFormatter_print_bd9d8d12f6_Test {

    private Formatter<PetType> petTypeFormatter;

    @Mock
    private PetType petType;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        petTypeFormatter = new PetTypeFormatter();
    }

    @Test
    public void testPrintSuccess() {
        String expectedName = "Dog";
        when(petType.getName()).thenReturn(expectedName);

        String actualName = petTypeFormatter.print(petType, Locale.ENGLISH);
        assertEquals(expectedName, actualName, "The expected pet type name does not match the actual name.");
    }

    @Test
    public void testPrintFailure() {
        String expectedName = "Cat";
        when(petType.getName()).thenReturn("Dog");

        String actualName = petTypeFormatter.print(petType, Locale.ENGLISH);
        assertEquals(expectedName, actualName, "The expected pet type name does not match the actual name.");
    }
}
