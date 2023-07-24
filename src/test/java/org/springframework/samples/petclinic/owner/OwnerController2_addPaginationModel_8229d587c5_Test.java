package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OwnerController2_addPaginationModel_8229d587c5_Test {

    @Mock
    Page<Owner> paginated;

    @InjectMocks
    OwnerController ownerController;

    @Test
    public void testAddPaginationModelSuccess() {
        Model model = new BindingAwareModelMap();
        Owner owner1 = new Owner();
        Owner owner2 = new Owner();
        when(paginated.getContent()).thenReturn(Arrays.asList(owner1, owner2));
        when(paginated.getTotalPages()).thenReturn(2);
        when(paginated.getTotalElements()).thenReturn(2L);

        String view = ownerController.addPaginationModel(1, model, paginated);

        assertEquals("owners/ownersList", view);
        assertEquals(2, ((List<Owner>) model.getAttribute("listOwners")).size());
        assertEquals(1, model.getAttribute("currentPage"));
        assertEquals(2, model.getAttribute("totalPages"));
        assertEquals(2L, model.getAttribute("totalItems"));
    }

    @Test
    public void testAddPaginationModelFailure() {
        Model model = new BindingAwareModelMap();
        when(paginated.getContent()).thenReturn(null);
        when(paginated.getTotalPages()).thenReturn(0);
        when(paginated.getTotalElements()).thenReturn(0L);

        String view = ownerController.addPaginationModel(1, model, paginated);

        assertEquals("owners/ownersList", view);
        assertEquals(null, model.getAttribute("listOwners"));
        assertEquals(1, model.getAttribute("currentPage"));
        assertEquals(0, model.getAttribute("totalPages"));
        assertEquals(0L, model.getAttribute("totalItems"));
    }
}
