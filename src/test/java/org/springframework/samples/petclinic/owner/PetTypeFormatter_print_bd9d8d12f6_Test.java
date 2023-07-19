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

    @Autowired
    Formatter<PetType> petTypeFormatter;

    @Mock
    private PetType petType;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testPrintPetType() throws ParseException {
        String petTypeName = "Dog";
        when(petType.getName()).thenReturn(petTypeName);

        String result = petTypeFormatter.print(petType, Locale.getDefault());
        assertEquals(petTypeName, result, "Printed pet type name should match the mock value");
    }

    @Test
    public void testPrintNullPetType() throws ParseException {
        when(petType.getName()).thenReturn(null);

        String result = petTypeFormatter.print(petType, Locale.getDefault());
        assertEquals("", result, "Printed pet type name should be empty for null pet type name");
    }
}
