package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PetTypeFormatter_print_bd9d8d12f6_Test {

    @Mock
    PetType petType;

    @InjectMocks
    PetTypeFormatter petTypeFormatter;

    @BeforeEach
    public void setup() {
        when(petType.getName()).thenReturn("Dog");
    }

    @Test
    public void testPrintMethodWithValidPetType() {
        String result = petTypeFormatter.print(petType, Locale.ENGLISH);
        assertEquals("Dog", result);
    }

    @Test
    public void testPrintMethodWithNullPetType() {
        String result = petTypeFormatter.print(null, Locale.ENGLISH);
        assertEquals("", result);
    }
}
