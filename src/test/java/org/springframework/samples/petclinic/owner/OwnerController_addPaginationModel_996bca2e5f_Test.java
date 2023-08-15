package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.ui.Model;

public class OwnerController_addPaginationModel_996bca2e5f_Test {

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
        int page = 1;
        List<Owner> owners = new ArrayList<>();
        Page<Owner> paginated = new PageImpl<>(owners);
        when(model.addAttribute("listOwners", paginated)).thenReturn(model);
        when(model.addAttribute("currentPage", page)).thenReturn(model);
        when(model.addAttribute("totalPages", paginated.getTotalPages())).thenReturn(model);
        when(model.addAttribute("totalItems", paginated.getTotalElements())).thenReturn(model);

        String result = ownerController.addPaginationModel(page, model, paginated);
        assertEquals("owners/ownersList", result);
    }

    @Test
    public void testAddPaginationModelEmptyPage() {
        int page = 1;
        List<Owner> owners = new ArrayList<>();
        Page<Owner> paginated = Page.empty();
        when(model.addAttribute("listOwners", paginated)).thenReturn(model);
        when(model.addAttribute("currentPage", page)).thenReturn(model);
        when(model.addAttribute("totalPages", paginated.getTotalPages())).thenReturn(model);
        when(model.addAttribute("totalItems", paginated.getTotalElements())).thenReturn(model);

        String result = ownerController.addPaginationModel(page, model, paginated);
        assertEquals("owners/ownersList", result);
    }
}
