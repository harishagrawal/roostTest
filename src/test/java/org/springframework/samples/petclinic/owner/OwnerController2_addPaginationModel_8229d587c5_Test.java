package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;

public class OwnerController2_addPaginationModel_8229d587c5_Test {

    @InjectMocks
    OwnerController2 ownerController2 = new OwnerController2();

    @Mock
    Model model = Mockito.mock(Model.class);

    @Mock
    Page<Owner> paginated = Mockito.mock(Page.class);

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddPaginationModel() {
        int page = 1;
        List<Owner> listOwners = Arrays.asList(new Owner(), new Owner());

        when(paginated.getContent()).thenReturn(listOwners);
        when(paginated.getTotalPages()).thenReturn(2);
        when(paginated.getTotalElements()).thenReturn(5L);

        String viewName = ownerController2.addPaginationModel(page, model, paginated);
        assertEquals("owners/ownersList", viewName);
    }

    @Test
    public void testAddPaginationModel_EmptyList() {
        int page = 1;
        List<Owner> listOwners = Arrays.asList();

        when(paginated.getContent()).thenReturn(listOwners);
        when(paginated.getTotalPages()).thenReturn(0);
        when(paginated.getTotalElements()).thenReturn(0L);

        String viewName = ownerController2.addPaginationModel(page, model, paginated);
        assertEquals("owners/ownersList", viewName);
    }
}
