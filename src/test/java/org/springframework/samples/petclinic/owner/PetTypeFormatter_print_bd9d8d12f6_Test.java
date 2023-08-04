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
    PetType petType;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testPrint_ValidPetType() throws ParseException {
        when(petType.getName()).thenReturn("Dog");

        String petTypeName = petTypeFormatter.print(petType, Locale.US);

        assertEquals("Dog", petTypeName);
    }

    @Test
    public void testPrint_NullPetType() throws ParseException {
        when(petType.getName()).thenReturn(null);

        String petTypeName = petTypeFormatter.print(petType, Locale.US);

        assertEquals(null, petTypeName);
    }
}
