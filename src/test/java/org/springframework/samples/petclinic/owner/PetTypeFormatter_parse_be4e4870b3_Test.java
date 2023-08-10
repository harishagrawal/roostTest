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
public class PetTypeFormatter_parse_be4e4870b3_Test {

    @Mock
    private OwnerRepository owners;

    @InjectMocks
    private PetTypeFormatter petTypeFormatter;

    private Locale locale = Locale.getDefault();

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
        PetType parsedType = petTypeFormatter.parse("Dog", locale);
        assertEquals(dog, parsedType);

        parsedType = petTypeFormatter.parse("Cat", locale);
        assertEquals(cat, parsedType);
    }

    @Test
    public void testParseFailure() {
        assertThrows(ParseException.class, () -> petTypeFormatter.parse("Bird", locale));
    }
}
