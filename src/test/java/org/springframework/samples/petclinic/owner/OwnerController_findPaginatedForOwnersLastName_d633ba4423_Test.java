package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class OwnerController_findPaginatedForOwnersLastName_d633ba4423_Test {

    @InjectMocks
    private OwnerController ownerController;

    @Mock
    private OwnerRepository owners;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindPaginatedForOwnersLastName() {
        Owner owner1 = new Owner();
        owner1.setLastName("Smith");
        Owner owner2 = new Owner();
        owner2.setLastName("Smith");
        Page<Owner> ownersPage = new PageImpl<>(Arrays.asList(owner1, owner2));

        when(owners.findByLastName("Smith", PageRequest.of(0, 5))).thenReturn(ownersPage);

        Page<Owner> result = ownerController.findPaginatedForOwnersLastName(1, "Smith");

        assertEquals(ownersPage, result);
    }

    @Test
    public void testFindPaginatedForOwnersLastName_noOwnersFound() {
        Page<Owner> ownersPage = Page.empty();

        when(owners.findByLastName("Unknown", PageRequest.of(0, 5))).thenReturn(ownersPage);

        Page<Owner> result = ownerController.findPaginatedForOwnersLastName(1, "Unknown");

        assertEquals(ownersPage, result);
    }

}
