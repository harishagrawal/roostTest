package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class OwnerController_addPaginationModel_8229d587c5_Test {

    @Test
    public void testAddPaginationModel() {
        Model model = Mockito.mock(Model.class);
        Page<Owner> paginated = Mockito.mock(Page.class);
        Owner owner1 = new Owner();
        Owner owner2 = new Owner();
        List<Owner> listOwners = Arrays.asList(owner1, owner2);
        int page = 1;

        when(paginated.getContent()).thenReturn(listOwners);
        when(paginated.getTotalPages()).thenReturn(5);
        when(paginated.getTotalElements()).thenReturn(10L);

        String result = new OwnerController().addPaginationModel(page, model, paginated);

        assertEquals("owners/ownersList", result);
        verify(model).addAttribute("listOwners", listOwners);
        verify(model).addAttribute("currentPage", page);
        verify(model).addAttribute("totalPages", 5);
        verify(model).addAttribute("totalItems", 10L);
    }

    @Test
    public void testAddPaginationModel_EmptyPage() {
        Model model = Mockito.mock(Model.class);
        Page<Owner> paginated = Mockito.mock(Page.class);
        List<Owner> listOwners = Arrays.asList();
        int page = 1;

        when(paginated.getContent()).thenReturn(listOwners);
        when(paginated.getTotalPages()).thenReturn(0);
        when(paginated.getTotalElements()).thenReturn(0L);

        String result = new OwnerController().addPaginationModel(page, model, paginated);

        assertEquals("owners/ownersList", result);
        verify(model).addAttribute("listOwners", listOwners);
        verify(model).addAttribute("currentPage", page);
        verify(model).addAttribute("totalPages", 0);
        verify(model).addAttribute("totalItems", 0L);
    }
}
