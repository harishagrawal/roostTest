package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OwnerController_addPaginationModel_8229d587c5_Test {

    @InjectMocks
    private OwnerController ownerController;

    @Mock
    private Model model;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddPaginationModel() {
        Owner owner1 = new Owner();
        Owner owner2 = new Owner();
        List<Owner> owners = Arrays.asList(owner1, owner2);
        Page<Owner> paginated = new PageImpl<>(owners);
        Model model = new BindingAwareModelMap();

        String view = ownerController.addPaginationModel(1, model, paginated);

        assertEquals("owners/ownersList", view);
        assertTrue(model.containsAttribute("listOwners"));
        assertTrue(model.containsAttribute("currentPage"));
        assertTrue(model.containsAttribute("totalPages"));
        assertTrue(model.containsAttribute("totalItems"));
        assertEquals(owners, model.getAttribute("listOwners"));
        assertEquals(1, model.getAttribute("currentPage"));
        assertEquals(1, model.getAttribute("totalPages"));
        assertEquals(2, model.getAttribute("totalItems"));
    }

    @Test
    public void testAddPaginationModel_NoOwners() {
        List<Owner> owners = Arrays.asList();
        Page<Owner> paginated = new PageImpl<>(owners);
        Model model = new BindingAwareModelMap();

        String view = ownerController.addPaginationModel(1, model, paginated);

        assertEquals("owners/ownersList", view);
        assertTrue(model.containsAttribute("listOwners"));
        assertTrue(model.containsAttribute("currentPage"));
        assertTrue(model.containsAttribute("totalPages"));
        assertTrue(model.containsAttribute("totalItems"));
        assertEquals(owners, model.getAttribute("listOwners"));
        assertEquals(1, model.getAttribute("currentPage"));
        assertEquals(0, model.getAttribute("totalPages"));
        assertEquals(0, model.getAttribute("totalItems"));
    }
}
