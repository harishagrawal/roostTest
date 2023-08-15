package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class OwnerController_findPaginatedForOwnersLastName_5e7208e66f_Test {

    @InjectMocks
    private OwnerController ownerController;

    @Mock
    private OwnerRepository owners;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindPaginatedForOwnersLastName_Success() {
        String lastName = "Smith";
        int page = 1;
        Page<Owner> ownerPage = mock(Page.class);

        when(owners.findByLastName(lastName, PageRequest.of(page - 1, 5))).thenReturn(ownerPage);

        Page<Owner> result = ownerController.findPaginatedForOwnersLastName(page, lastName);

        assertEquals(ownerPage, result);
        verify(owners, times(1)).findByLastName(lastName, PageRequest.of(page - 1, 5));
    }

    @Test
    public void testFindPaginatedForOwnersLastName_PageOutOfRange() {
        String lastName = "Smith";
        int page = -1;
        Page<Owner> ownerPage = mock(Page.class);

        when(owners.findByLastName(lastName, PageRequest.of(page - 1, 5))).thenReturn(ownerPage);

        Page<Owner> result = ownerController.findPaginatedForOwnersLastName(page, lastName);

        assertEquals(ownerPage, result);
        verify(owners, times(1)).findByLastName(lastName, PageRequest.of(page - 1, 5));
    }
}
