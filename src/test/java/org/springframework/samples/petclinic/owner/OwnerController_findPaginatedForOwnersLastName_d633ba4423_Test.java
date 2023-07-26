package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class OwnerController_findPaginatedForOwnersLastName_d633ba4423_Test {

    @InjectMocks
    private OwnerController ownerController;

    @Mock
    private OwnerRepository owners;

    @Test
    public void testFindPaginatedForOwnersLastName_Success() {
        int page = 1;
        String lastname = "Smith";
        List<Owner> ownerList = Arrays.asList(new Owner(), new Owner(), new Owner());
        Page<Owner> ownerPage = new PageImpl<>(ownerList);
        when(owners.findByLastName(lastname, PageRequest.of(page - 1, 5))).thenReturn(ownerPage);
        Page<Owner> result = ownerController.findPaginatedForOwnersLastName(page, lastname);
        assertEquals(ownerPage, result, "Should return expected owner page");
    }

    @Test
    public void testFindPaginatedForOwnersLastName_NoOwnersFound() {
        int page = 1;
        String lastname = "NonExistentLastName";
        Page<Owner> ownerPage = Page.empty();
        when(owners.findByLastName(lastname, PageRequest.of(page - 1, 5))).thenReturn(ownerPage);
        Page<Owner> result = ownerController.findPaginatedForOwnersLastName(page, lastname);
        assertEquals(ownerPage, result, "Should return empty owner page");
    }
}
