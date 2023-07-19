package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Collections;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class PetTypeFormatter_PetTypeFormatter_aab2a90f9f_Test {

    private Formatter<PetType> petTypeFormatter;

    @Mock
    private OwnerRepository ownerRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.petTypeFormatter = new PetTypeFormatter();
    }

    @Test
    public void testPrint() {
        PetType petType = new PetType();
        petType.setName("Dog");
        String petTypeName = this.petTypeFormatter.print(petType, Locale.ENGLISH);
        assertEquals("Dog", petTypeName);
    }

    @Test
    public void testParse() throws ParseException {
        PetType petType = new PetType();
        petType.setName("Cat");
        when(ownerRepository.findPetTypes()).thenReturn(Collections.singleton(petType));
        PetType parsedPetType = this.petTypeFormatter.parse("Cat", Locale.ENGLISH);
        assertEquals(petType, parsedPetType);
    }

    @Test
    public void testParse_NotFound() {
        when(ownerRepository.findPetTypes()).thenReturn(Collections.emptyList());
        assertThrows(ParseException.class, () -> this.petTypeFormatter.parse("Bird", Locale.ENGLISH));
    }
}
