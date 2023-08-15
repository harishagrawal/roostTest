package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Locale;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class PetTypeFormatter_PetTypeFormatter_d71c071163_Test {

    private PetTypeFormatter petTypeFormatter;

    @Mock
    private OwnerRepository owners;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        petTypeFormatter = new PetTypeFormatter(owners);
    }

    @Test
    public void testPetTypeFormatter_Success() {
        PetType petType = new PetType();
        petType.setId(1);
        petType.setName("Dog");

        List<PetType> petTypes = new ArrayList<>();
        petTypes.add(petType);

        when(owners.findPetTypes()).thenReturn(petTypes);

        PetType result = null;
        try {
            result = petTypeFormatter.parse("Dog", Locale.ENGLISH);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assertEquals(petType, result);
    }

    @Test
    public void testPetTypeFormatter_Failure() {
        PetType petType = new PetType();
        petType.setId(2);
        petType.setName("Cat");

        List<PetType> petTypes = new ArrayList<>();
        petTypes.add(petType);

        when(owners.findPetTypes()).thenReturn(petTypes);

        PetType result = null;
        try {
            result = petTypeFormatter.parse("Dog", Locale.ENGLISH);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assertEquals(petType, result);
    }
}
