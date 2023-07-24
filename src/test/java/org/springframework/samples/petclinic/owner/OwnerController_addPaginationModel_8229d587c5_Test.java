package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.ui.Model;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OwnerController_addPaginationModel_8229d587c5_Test {

    @Mock
    private Model model;

    @InjectMocks
    private OwnerController ownerController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddPaginationModel() {
        Owner owner1 = new Owner();
        Owner owner2 = new Owner();
        Page<Owner> paginated = new PageImpl<>(Arrays.asList(owner1, owner2));
        String result = ownerController.addPaginationModel(1, model, paginated);

        assertEquals("owners/ownersList", result);
    }

    @Test
    public void testAddPaginationModel_EmptyPage() {
        Page<Owner> paginated = new PageImpl<>(Arrays.asList());
        String result = ownerController.addPaginationModel(1, model, paginated);

        assertEquals("owners/ownersList", result);
    }
}
