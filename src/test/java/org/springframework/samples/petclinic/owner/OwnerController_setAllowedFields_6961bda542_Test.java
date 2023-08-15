package org.springframework.samples.petclinic.owner;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.bind.WebDataBinder;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class OwnerController_setAllowedFields_6961bda542_Test {

    @InjectMocks
    OwnerController ownerController;

    @Mock
    WebDataBinder dataBinder;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSetAllowedFields() {
        ownerController.setAllowedFields(dataBinder);
        verify(dataBinder, times(1)).setDisallowedFields("id");
    }

    @Test
    public void testSetAllowedFieldsWithDifferentField() {
        ownerController.setAllowedFields(dataBinder);
        verify(dataBinder, times(0)).setDisallowedFields("name");
    }
}
