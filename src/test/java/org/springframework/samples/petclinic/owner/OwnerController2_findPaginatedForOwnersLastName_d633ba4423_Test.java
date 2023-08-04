package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OwnerController2_findPaginatedForOwnersLastName_d633ba4423_Test {

    @InjectMocks
    private OwnerController ownerController;

    @Mock
    private OwnerRepository owners;

    @Test
    public void testFindPaginatedForOwnersLastName_success() {
        String lastname = "Smith";
        int page = 1;
        List<Owner> ownerList = Arrays.asList(new Owner(), new Owner());
        Page<Owner> ownerPage = new PageImpl<>(ownerList);

        when(owners.findByLastName(lastname, PageRequest.of(page - 1, 5))).thenReturn(ownerPage);

        Page<Owner> result = ownerController.findPaginatedForOwnersLastName(page, lastname);

        assertEquals(ownerPage, result);
        verify(owners, times(1)).findByLastName(lastname, PageRequest.of(page - 1, 5));
    }

    @Test
    public void testFindPaginatedForOwnersLastName_noOwnersFound() {
        String lastname = "Doe";
        int page = 1;

        when(owners.findByLastName(lastname, PageRequest.of(page - 1, 5))).thenReturn(Page.empty());

        Page<Owner> result = ownerController.findPaginatedForOwnersLastName(page, lastname);

        assertTrue(result.isEmpty());
        verify(owners, times(1)).findByLastName(lastname, PageRequest.of(page - 1, 5));
    }
}
