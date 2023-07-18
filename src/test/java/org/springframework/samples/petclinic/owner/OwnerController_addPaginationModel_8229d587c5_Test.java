package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

public class OwnerController_addPaginationModel_8229d587c5_Test {

    @InjectMocks
    private OwnerController ownerController;

    @Mock
    private Model model;

    @BeforeEach
    public void setUp() {
        ownerController = new OwnerController();
    }

    @Test
    public void testAddPaginationModel() {
        Owner owner1 = new Owner();
        Owner owner2 = new Owner();
        List<Owner> owners = Arrays.asList(owner1, owner2);
        Page<Owner> paginated = new PageImpl<>(owners);

        String view = ownerController.addPaginationModel(1, model, paginated);

        assertEquals("owners/ownersList", view);
        verify(model).addAttribute("listOwners", paginated);
        verify(model).addAttribute("currentPage", 1);
        verify(model).addAttribute("totalPages", paginated.getTotalPages());
        verify(model).addAttribute("totalItems", paginated.getTotalElements());
    }

    @Test
    public void testAddPaginationModelWithEmptyPage() {
        Page<Owner> paginated = new PageImpl<>(Arrays.asList());

        String view = ownerController.addPaginationModel(1, model, paginated);

        assertEquals("owners/ownersList", view);
        verify(model).addAttribute("listOwners", paginated);
        verify(model).addAttribute("currentPage", 1);
        verify(model).addAttribute("totalPages", paginated.getTotalPages());
        verify(model).addAttribute("totalItems", paginated.getTotalElements());
    }
}
