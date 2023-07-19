package org.springframework.samples.petclinic.owner;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.bind.WebDataBinder;

import static org.mockito.Mockito.verify;

public class OwnerController2_setAllowedFields_72a497dba6_Test {

    @InjectMocks
    OwnerController ownerController = new OwnerController();

    @Mock
    WebDataBinder dataBinder = new WebDataBinder();

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSetAllowedFields() {
        ownerController.setAllowedFields(dataBinder);
        verify(dataBinder).setDisallowedFields("id");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetAllowedFieldsWithInvalidArgument() {
        ownerController.setAllowedFields(null);
    }
}
