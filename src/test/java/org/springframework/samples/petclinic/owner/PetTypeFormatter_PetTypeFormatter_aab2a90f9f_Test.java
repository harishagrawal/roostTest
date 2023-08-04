package org.springframework.samples.petclinic.owner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PetTypeFormatter_PetTypeFormatter_aab2a90f9f_Test {

    @Mock
    private OwnerRepository owners;

    private PetTypeFormatter petTypeFormatter;

    @Before
    public void setup(){
        petTypeFormatter = new PetTypeFormatter(owners);
    }

    @Test
    public void testPetTypeFormatterSuccess() throws ParseException {
        PetType petType = new PetType();
        petType.setName("Dog");
        when(owners.findPetTypes()).thenReturn(Arrays.asList(petType));
        String petTypeName = petTypeFormatter.print(petType, Locale.ENGLISH);
        assertEquals(petType.getName(), petTypeName);
    }

    @Test(expected = ParseException.class)
    public void testPetTypeFormatterFailure() throws ParseException {
        when(owners.findPetTypes()).thenReturn((Collection<PetType>) null);
        petTypeFormatter.parse("Cat", Locale.ENGLISH);
    }
}
