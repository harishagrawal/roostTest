package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PetTypeFormatterParseBe4e4870b3Test {

    @Mock
    private OwnerRepository owners;

    @InjectMocks
    private PetTypeFormatter petTypeFormatter;

    private PetType dog;
    private PetType cat;

    @BeforeEach
    public void setup() {
        dog = new PetType();
        dog.setName("Dog");

        cat = new PetType();
        cat.setName("Cat");

        when(owners.findPetTypes()).thenReturn(Arrays.asList(dog, cat));
    }

    @Test
    public void testParseSuccess() throws ParseException {
        PetType parsedType = petTypeFormatter.parse("Dog", Locale.ENGLISH);
        assertEquals(dog, parsedType);
    }

    @Test
    public void testParseTypeNotFound() {
        assertThrows(ParseException.class, () -> petTypeFormatter.parse("Bird", Locale.ENGLISH));
    }
}
