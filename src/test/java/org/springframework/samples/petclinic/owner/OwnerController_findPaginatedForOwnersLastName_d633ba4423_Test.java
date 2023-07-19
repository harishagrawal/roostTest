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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OwnerController_findPaginatedForOwnersLastName_d633ba4423_Test {

    @InjectMocks
    private OwnerController ownerController;

    @Mock
    private OwnerRepository owners;

    @Test
    public void testFindPaginatedForOwnersLastName_Success() {
        Owner owner1 = new Owner();
        owner1.setLastName("Smith");
        Owner owner2 = new Owner();
        owner2.setLastName("Smith");
        Page<Owner> ownersPage = new PageImpl<>(Arrays.asList(owner1, owner2));

        when(owners.findByLastName("Smith", PageRequest.of(0, 5))).thenReturn(ownersPage);

        Page<Owner> result = ownerController.findPaginatedForOwnersLastName(1, "Smith");
        assertEquals(2, result.getTotalElements());
        assertEquals("Smith", result.getContent().get(0).getLastName());
    }

    @Test
    public void testFindPaginatedForOwnersLastName_NoOwnersFound() {
        Page<Owner> ownersPage = new PageImpl<>(Arrays.asList());

        when(owners.findByLastName("Doe", PageRequest.of(0, 5))).thenReturn(ownersPage);

        Page<Owner> result = ownerController.findPaginatedForOwnersLastName(1, "Doe");
        assertEquals(0, result.getTotalElements());
    }
}
