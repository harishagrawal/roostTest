package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class OwnerController_addPaginationModel_8229d587c5_Test {

    @InjectMocks
    private OwnerController ownerController;

    @Mock
    private Model model;

    @Mock
    private Page<Owner> paginated;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddPaginationModel_Success() {
        int page = 1;
        List<Owner> listOwners = Arrays.asList(new Owner());
        when(paginated.getContent()).thenReturn(listOwners);
        when(paginated.getTotalPages()).thenReturn(5);
        when(paginated.getTotalElements()).thenReturn((long) listOwners.size());

        String view = ownerController.addPaginationModel(page, model, paginated);

        verify(model, times(1)).addAttribute("listOwners", listOwners);
        verify(model, times(1)).addAttribute("currentPage", page);
        verify(model, times(1)).addAttribute("totalPages", 5);
        verify(model, times(1)).addAttribute("totalItems", (long) listOwners.size());

        assertEquals("owners/ownersList", view);
    }

    @Test
    public void testAddPaginationModel_EmptyOwnerList() {
        int page = 1;
        List<Owner> listOwners = Collections.emptyList();
        when(paginated.getContent()).thenReturn(listOwners);
        when(paginated.getTotalPages()).thenReturn(0);
        when(paginated.getTotalElements()).thenReturn((long) listOwners.size());

        String view = ownerController.addPaginationModel(page, model, paginated);

        verify(model, times(1)).addAttribute("listOwners", listOwners);
        verify(model, times(1)).addAttribute("currentPage", page);
        verify(model, times(1)).addAttribute("totalPages", 0);
        verify(model, times(1)).addAttribute("totalItems", (long) listOwners.size());

        assertEquals("owners/ownersList", view);
    }
}
