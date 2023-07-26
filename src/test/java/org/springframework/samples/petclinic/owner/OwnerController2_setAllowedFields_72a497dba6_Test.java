package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.never;

public class OwnerController2_setAllowedFields_72a497dba6_Test {

    @InjectMocks
    OwnerController ownerController = new OwnerController();

    @Mock
    WebDataBinder dataBinder = new WebDataBinder();

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSetAllowedFields() {
        ownerController.setAllowedFields(dataBinder);
        verify(dataBinder, times(1)).setDisallowedFields("id");
    }

    @Test
    public void testSetAllowedFields_withNullDataBinder() {
        ownerController.setAllowedFields(null);
        verify(dataBinder, never()).setDisallowedFields("id");
    }
}
