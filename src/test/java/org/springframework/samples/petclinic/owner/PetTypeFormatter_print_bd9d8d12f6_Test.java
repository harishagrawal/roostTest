package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class PetTypeFormatter_print_bd9d8d12f6_Test {

    private PetTypeFormatter petTypeFormatter;

    @Mock
    private PetType petType;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        petTypeFormatter = new PetTypeFormatter();
    }

    @Test
    public void testPrintPetTypeName() {
        when(petType.getName()).thenReturn("Dog");
        String result = petTypeFormatter.print(petType, Locale.ENGLISH);
        assertEquals("Dog", result);
    }

    @Test
    public void testPrintPetTypeNameWithDifferentLocale() {
        when(petType.getName()).thenReturn("Dog");
        String result = petTypeFormatter.print(petType, Locale.FRENCH);
        assertEquals("Dog", result);
    }
}
