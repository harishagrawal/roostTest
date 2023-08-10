package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Collection;
import java.util.Collections;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class PetTypeFormatter_PetTypeFormatter_aab2a90f9f_Test {

    @Autowired
    Formatter<PetType> formatter;

    @Mock
    OwnerRepository owners;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        formatter = new PetTypeFormatter();
    }

    @Test
    public void testPrint() {
        PetType petType = new PetType();
        petType.setName("Dog");
        String petTypeName = formatter.print(petType, Locale.ENGLISH);
        assertEquals("Dog", petTypeName);
    }

    @Test
    public void testParse() throws ParseException {
        PetType petType = new PetType();
        petType.setName("Dog");
        when(owners.findPetTypes()).thenReturn(Collections.singleton(petType));
        PetType parsedPetType = formatter.parse("Dog", Locale.ENGLISH);
        assertEquals(petType, parsedPetType);
    }
}
