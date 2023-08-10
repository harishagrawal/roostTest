package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;

public class OwnerController2_addPaginationModel_8229d587c5_Test {

    @Test
    public void testAddPaginationModel() {
        Model model = mock(Model.class);
        Page<Owner> paginated = mock(Page.class);
        List<Owner> listOwners = new ArrayList<>();
        int page = 1;

        when(paginated.getContent()).thenReturn(listOwners);
        when(paginated.getTotalPages()).thenReturn(5);
        when(paginated.getTotalElements()).thenReturn(10L);

        String result = addPaginationModel(page, model, paginated);

        assertEquals("owners/ownersList", result);
        // TODO: Add verifications for model attributes
    }

    @Test
    public void testAddPaginationModel_EmptyPage() {
        Model model = mock(Model.class);
        Page<Owner> paginated = mock(Page.class);
        List<Owner> listOwners = new ArrayList<>();
        int page = 0;

        when(paginated.getContent()).thenReturn(listOwners);
        when(paginated.getTotalPages()).thenReturn(0);
        when(paginated.getTotalElements()).thenReturn(0L);

        String result = addPaginationModel(page, model, paginated);

        assertEquals("owners/ownersList", result);
        // TODO: Add verifications for model attributes
    }

    private String addPaginationModel(int page, Model model, Page<Owner> paginated) {
        model.addAttribute("listOwners", paginated);
        List<Owner> listOwners = paginated.getContent();
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", paginated.getTotalPages());
        model.addAttribute("totalItems", paginated.getTotalElements());
        model.addAttribute("listOwners", listOwners);
        return "owners/ownersList";
    }
}
