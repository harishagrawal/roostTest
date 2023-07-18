package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
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

    private OwnerController ownerController;
    private Model model;
    private Page<Owner> paginated;

    @BeforeEach
    public void setup() {
        this.ownerController = new OwnerController();
        this.model = Mockito.mock(Model.class);
        this.paginated = Mockito.mock(Page.class);
    }

    @Test
    public void testAddPaginationModel() {
        List<Owner> listOwners = Arrays.asList(new Owner(), new Owner());
        when(this.paginated.getContent()).thenReturn(listOwners);
        when(this.paginated.getTotalPages()).thenReturn(5);
        when(this.paginated.getTotalElements()).thenReturn(10L);

        String result = this.ownerController.addPaginationModel(1, this.model, this.paginated);

        verify(this.model).addAttribute("listOwners", listOwners);
        verify(this.model).addAttribute("currentPage", 1);
        verify(this.model).addAttribute("totalPages", 5);
        verify(this.model).addAttribute("totalItems", 10L);
        assertEquals("owners/ownersList", result);
    }

    @Test
    public void testAddPaginationModelWithNoOwners() {
        List<Owner> listOwners = Arrays.asList();
        when(this.paginated.getContent()).thenReturn(listOwners);
        when(this.paginated.getTotalPages()).thenReturn(0);
        when(this.paginated.getTotalElements()).thenReturn(0L);

        String result = this.ownerController.addPaginationModel(1, this.model, this.paginated);

        verify(this.model).addAttribute("listOwners", listOwners);
        verify(this.model).addAttribute("currentPage", 1);
        verify(this.model).addAttribute("totalPages", 0);
        verify(this.model).addAttribute("totalItems", 0L);
        assertEquals("owners/ownersList", result);
    }
}
