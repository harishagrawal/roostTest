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
import static org.mockito.Mockito.when;

public class OwnerController_addPaginationModel_8229d587c5_Test {

    @InjectMocks
    private OwnerController ownerController;

    @Mock
    private Page<Owner> paginated;

    private Model model;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        model = new BindingAwareModelMap();
    }

    @Test
    public void testAddPaginationModelSuccess() {
        int page = 1;
        List<Owner> listOwners = Arrays.asList(new Owner(), new Owner());
        when(paginated.getContent()).thenReturn(listOwners);
        when(paginated.getTotalPages()).thenReturn(3);
        when(paginated.getTotalElements()).thenReturn(10L);

        String result = ownerController.addPaginationModel(page, model, paginated);

        assertEquals("owners/ownersList", result);
        assertEquals(listOwners, model.getAttribute("listOwners"));
        assertEquals(page, model.getAttribute("currentPage"));
        assertEquals(3, model.getAttribute("totalPages"));
        assertEquals(10L, model.getAttribute("totalItems"));
    }

    @Test
    public void testAddPaginationModelEmptyPage() {
        int page = 0;
        List<Owner> listOwners = Arrays.asList();
        Page<Owner> emptyPage = new PageImpl<>(listOwners);
        String result = ownerController.addPaginationModel(page, model, emptyPage);

        assertEquals("owners/ownersList", result);
        assertEquals(listOwners, model.getAttribute("listOwners"));
        assertEquals(page, model.getAttribute("currentPage"));
        assertEquals(0, model.getAttribute("totalPages"));
        assertEquals(0L, model.getAttribute("totalItems"));
    }
}
