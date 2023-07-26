package org.springframework.samples.petclinic.owner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PetTypeFormatter_parse_be4e4870b3_Test {

    @InjectMocks
    private PetTypeFormatter petTypeFormatter;

    @Mock
    private OwnerRepository owners;

    private Locale locale;

    private PetType dog;
    private PetType cat;

    @Before
    public void setup() {
        dog = new PetType();
        dog.setName("Dog");

        cat = new PetType();
        cat.setName("Cat");

        locale = Locale.getDefault();
    }

    @Test
    public void testParse_Success() throws ParseException {
        when(owners.findPetTypes()).thenReturn(Arrays.asList(dog, cat));

        PetType actual = petTypeFormatter.parse("Dog", locale);
        assertEquals(dog, actual);

        actual = petTypeFormatter.parse("Cat", locale);
        assertEquals(cat, actual);
    }

    @Test(expected = ParseException.class)
    public void testParse_Failure() throws ParseException {
        when(owners.findPetTypes()).thenReturn(Arrays.asList(dog, cat));

        petTypeFormatter.parse("Bird", locale);
    }
}
