package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;

public class OwnerController2_addPaginationModel_996bca2e5f_Test {

    private Model model;
    private OwnerController2 ownerController;

    @BeforeEach
    public void setup() {
        model = mock(Model.class);
        ownerController = new OwnerController2();
    }

    @Test
    public void testAddPaginationModel_withValidPage() {
        int page = 1;
        List<Owner> listOwners = new ArrayList<>();
        when(model.getAttribute("owners")).thenReturn(listOwners);
        when(model.getAttribute("totalPages")).thenReturn(5);
        when(model.getAttribute("totalElements")).thenReturn(10L);

        String result = ownerController.addPaginationModel(page, model);
        assertEquals("owners/ownersList", result);
    }

    @Test
    public void testAddPaginationModel_withInvalidPage() {
        int page = -1;
        List<Owner> listOwners = new ArrayList<>();
        when(model.getAttribute("owners")).thenReturn(listOwners);
        when(model.getAttribute("totalPages")).thenReturn(5);
        when(model.getAttribute("totalElements")).thenReturn(10L);

        String result = ownerController.addPaginationModel(page, model);
        assertEquals("owners/ownersList", result);
    }
}
