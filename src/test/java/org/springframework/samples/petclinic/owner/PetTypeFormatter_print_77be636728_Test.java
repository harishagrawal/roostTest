package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class PetTypeFormatter_print_77be636728_Test {

    private PetTypeFormatter petTypeFormatter;

    private MessageSource messageSource;

    @BeforeEach
    public void setup() {
        messageSource = Mockito.mock(MessageSource.class);
        petTypeFormatter = new PetTypeFormatter(messageSource);
    }

    @Test
    public void testPrintSuccess() {
        PetType petType = new PetType();
        petType.setName("Dog");
        Locale locale = LocaleContextHolder.getLocale();
        when(messageSource.getMessage("petType.Dog", null, locale)).thenReturn("Dog");
        String result = petTypeFormatter.print(petType, locale);
        assertEquals("Dog", result);
    }

    @Test
    public void testPrintFailure() {
        PetType petType = new PetType();
        petType.setName("Cat");
        Locale locale = LocaleContextHolder.getLocale();
        when(messageSource.getMessage("petType.Cat", null, locale)).thenReturn("Dog");
        String result = petTypeFormatter.print(petType, locale);
        assertEquals("Cat", result); // This test will fail as we are returning "Dog" for "Cat"
    }
}
