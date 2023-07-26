package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

public class PetTypeFormatter_PetTypeFormatter_aab2a90f9f_Test {

    private PetTypeFormatter petTypeFormatter;

    @Mock
    private OwnerRepository ownerRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        petTypeFormatter = new PetTypeFormatter(ownerRepository);
    }

    @Test
    public void testPetTypeFormatter_WithNonNullOwnerRepository() {
        assertNotNull(petTypeFormatter);
    }

    @Test
    public void testPetTypeFormatter_WithNullOwnerRepository() {
        when(ownerRepository.findAll()).thenReturn(null);
        Collection<PetType> petTypes = new ArrayList<>();
        assertNull(petTypeFormatter.parse("Dog", Locale.ENGLISH));
    }
}
