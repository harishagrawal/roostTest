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
    private PetTypeFormatter formatter;

    @Mock
    private OwnerRepository owners;

    private PetType dog;
    private PetType cat;

    @Before
    public void setup() {
        dog = new PetType();
        dog.setName("Dog");

        cat = new PetType();
        cat.setName("Cat");

        when(owners.findPetTypes()).thenReturn(Arrays.asList(dog, cat));
    }

    @Test
    public void testParseDog() throws ParseException {
        PetType petType = formatter.parse("Dog", Locale.ENGLISH);
        assertEquals(dog, petType);
    }

    @Test
    public void testParseCat() throws ParseException {
        PetType petType = formatter.parse("Cat", Locale.ENGLISH);
        assertEquals(cat, petType);
    }

    @Test(expected = ParseException.class)
    public void testParseNonExistent() throws ParseException {
        formatter.parse("Elephant", Locale.ENGLISH);
    }
}
