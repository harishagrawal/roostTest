package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class OwnerController_addPaginationModel_8229d587c5_Test {

    private OwnerController controller;

    @Mock
    private Model model;

    @Mock
    private Page<Owner> paginated;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        controller = new OwnerController();
    }

    @Test
    public void testAddPaginationModel() {
        int page = 1;
        List<Owner> listOwners = new ArrayList<>();
        when(paginated.getContent()).thenReturn(listOwners);
        when(paginated.getTotalPages()).thenReturn(10);
        when(paginated.getTotalElements()).thenReturn(100L);

        String view = controller.addPaginationModel(page, model, paginated);

        verify(model, times(1)).addAttribute("listOwners", listOwners);
        verify(model, times(1)).addAttribute("currentPage", page);
        verify(model, times(1)).addAttribute("totalPages", 10);
        verify(model, times(1)).addAttribute("totalItems", 100L);
        assert(view.equals("owners/ownersList"));
    }

    @Test
    public void testAddPaginationModel_EmptyPage() {
        int page = 1;
        List<Owner> listOwners = new ArrayList<>();
        when(paginated.getContent()).thenReturn(listOwners);
        when(paginated.getTotalPages()).thenReturn(0);
        when(paginated.getTotalElements()).thenReturn(0L);

        String view = controller.addPaginationModel(page, model, paginated);

        verify(model, times(1)).addAttribute("listOwners", listOwners);
        verify(model, times(1)).addAttribute("currentPage", page);
        verify(model, times(1)).addAttribute("totalPages", 0);
        verify(model, times(1)).addAttribute("totalItems", 0L);
        assert(view.equals("owners/ownersList"));
    }
}
