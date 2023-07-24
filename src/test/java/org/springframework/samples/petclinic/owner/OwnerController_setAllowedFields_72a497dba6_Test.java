package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;

import static org.mockito.Mockito.verify;

public class OwnerController_setAllowedFields_72a497dba6_Test {

    @Mock
    private WebDataBinder dataBinder;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSetAllowedFields() {
        OwnerController ownerController = new OwnerController();
        ownerController.setAllowedFields(dataBinder);
        verify(dataBinder).setDisallowedFields("id");
    }

    @Test
    public void testSetAllowedFieldsWithNullBinder() {
        try {
            OwnerController ownerController = new OwnerController();
            ownerController.setAllowedFields(null);
        } catch (Exception e) {
            assert (e instanceof NullPointerException);
        }
    }
}
