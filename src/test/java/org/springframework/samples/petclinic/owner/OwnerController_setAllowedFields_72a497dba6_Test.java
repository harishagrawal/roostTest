package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.web.bind.WebDataBinder;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.never;
import static org.mockito.MockitoAnnotations.openMocks;

public class OwnerController_setAllowedFields_72a497dba6_Test {

    @InjectMocks
    private OwnerController ownerController;

    @Mock
    private WebDataBinder dataBinder;

    @Test
    public void testSetAllowedFields() {
        openMocks(this);

        ownerController.setAllowedFields(dataBinder);

        verify(dataBinder).setDisallowedFields("id");
    }

    @Test
    public void testSetAllowedFieldsWithNull() {
        openMocks(this);

        ownerController.setAllowedFields(null);

        verify(dataBinder, never()).setDisallowedFields("id");
    }
}
