package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PetTypeFormatter_PetTypeFormatter_aab2a90f9f_Test {

    @Autowired
    PetTypeFormatter petTypeFormatter;

    @Mock
    OwnerRepository owners;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testPetTypeFormatter_Success() {
        String petType = "Dog";
        when(owners.findPetTypes()).thenReturn(mock(Collection.class));
        try {
            petTypeFormatter.parse(petType, Locale.ENGLISH);
        } catch (ParseException e) {
            fail("Parsing failed.");
        }
    }

    @Test
    public void testPetTypeFormatter_Failure() {
        String petType = "Dog";
        when(owners.findPetTypes()).thenReturn(null);
        assertThrows(ParseException.class, () -> petTypeFormatter.parse(petType, Locale.ENGLISH));
    }
}
