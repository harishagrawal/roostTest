package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class OwnerController_findPaginatedForOwnersLastName_d633ba4423_Test {

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
        Owner owner1 = new Owner();
        owner1.setLastName("Smith");
        Owner owner2 = new Owner();
        owner2.setLastName("Smith");
        List<Owner> ownerList = Arrays.asList(owner1, owner2);

        Pageable pageable = PageRequest.of(0, 5);
        Page<Owner> page = new PageImpl<>(ownerList, pageable, ownerList.size());
        when(owners.findByLastName("Smith", pageable)).thenReturn(page);

        Page<Owner> result = ownerController.findPaginatedForOwnersLastName(1, "Smith");
        assertEquals(page, result);
    }

    @Test
    public void testFindPaginatedForOwnersLastName_NoOwners() {
        Pageable pageable = PageRequest.of(0, 5);
        Page<Owner> page = Page.empty();
        when(owners.findByLastName("Unknown", pageable)).thenReturn(page);

        Page<Owner> result = ownerController.findPaginatedForOwnersLastName(1, "Unknown");
        assertEquals(page, result);
    }
}
