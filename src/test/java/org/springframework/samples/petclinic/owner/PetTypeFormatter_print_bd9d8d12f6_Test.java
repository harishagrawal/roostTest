package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class PetTypeFormatter_print_bd9d8d12f6_Test {

    @Autowired
    PetTypeFormatter petTypeFormatter;

    @Mock
    private MessageSource messageSource;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testPrint_PetTypeExists() {
        PetType petType = new PetType();
        petType.setName("Dog");
        Locale locale = LocaleContextHolder.getLocale();
        when(messageSource.getMessage("petType.Dog", null, locale)).thenReturn("Dog");
        String result = petTypeFormatter.print(petType, locale);
        assertEquals("Dog", result);
    }

    @Test
    public void testPrint_PetTypeIsNull() {
        PetType petType = null;
        Locale locale = LocaleContextHolder.getLocale();
        String result = petTypeFormatter.print(petType, locale);
        assertEquals("", result);
    }
}
