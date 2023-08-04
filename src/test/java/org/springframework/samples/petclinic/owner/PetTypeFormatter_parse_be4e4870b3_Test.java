package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class PetTypeFormatter_parse_be4e4870b3_Test {

    @InjectMocks
    PetTypeFormatter petTypeFormatter;

    @Mock
    OwnerRepository owners;

    Locale locale = Locale.getDefault();

    PetType dog;
    PetType cat;

    @BeforeEach
    public void setup() {
        dog = new PetType();
        dog.setName("Dog");

        cat = new PetType();
        cat.setName("Cat");

        when(owners.findPetTypes()).thenReturn(Arrays.asList(dog, cat));
    }

    @Test
    public void testParse_success() throws ParseException {
        PetType parsedPetType = petTypeFormatter.parse("Dog", locale);
        assertEquals(dog, parsedPetType);
    }

    @Test
    public void testParse_failure() {
        assertThrows(ParseException.class, () -> petTypeFormatter.parse("Bird", locale));
    }
}
