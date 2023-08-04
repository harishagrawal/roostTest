package org.springframework.samples.petclinic.owner;

import org.springframework.web.bind.WebDataBinder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OwnerController2_setAllowedFields_72a497dba6_Test {

    @Mock
    private WebDataBinder dataBinder;

    private OwnerController2 ownerController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        ownerController = new OwnerController2();
    }

    @Test
    public void testSetAllowedFields() {
        ownerController.setAllowedFields(dataBinder);
        verify(dataBinder).setDisallowedFields("id");
    }

    @Test
    public void testSetAllowedFieldsWithNull() {
        try {
            ownerController.setAllowedFields(null);
        } catch (IllegalArgumentException e) {
            assertEquals("dataBinder cannot be null", e.getMessage());
        }
    }
}
