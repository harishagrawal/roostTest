package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.util.Collections;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PetTypeFormatterTest {

    @Mock
    private OwnerRepository owners;

    @InjectMocks
    private PetTypeFormatter petTypeFormatter;

    @BeforeEach
    public void setup() {
        // TODO: Initialize the mock data
    }

    @Test
    public void testParse_PetTypeFound() throws ParseException {
        String petTypeName = "Dog";
        PetType petType = new PetType();
        petType.setName(petTypeName);

        when(owners.findPetTypes()).thenReturn(Collections.singleton(petType));

        PetType actualPetType = petTypeFormatter.parse(petTypeName, Locale.ENGLISH);

        assertEquals(petType, actualPetType);
    }

    @Test
    public void testParse_PetTypeNotFound() {
        String petTypeName = "Cat";

        when(owners.findPetTypes()).thenReturn(Collections.emptySet());

        assertThrows(ParseException.class, () -> petTypeFormatter.parse(petTypeName, Locale.ENGLISH));
    }
}
