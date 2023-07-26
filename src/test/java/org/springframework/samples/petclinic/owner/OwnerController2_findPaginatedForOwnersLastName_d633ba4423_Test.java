package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OwnerController2_findPaginatedForOwnersLastName_d633ba4423_Test {

    @InjectMocks
    OwnerController ownerController;

    @Mock
    OwnerRepository owners;

    @Test
    public void testFindPaginatedForOwnersLastName_Success() {
        Owner owner = new Owner();
        owner.setLastName("Smith");
        Page<Owner> page = new PageImpl<>(Collections.singletonList(owner));

        when(owners.findByLastName(any(String.class), any(Pageable.class))).thenReturn(page);

        Page<Owner> result = ownerController.findPaginatedForOwnersLastName(1, "Smith");

        assertEquals(1, result.getTotalElements());
        assertEquals("Smith", result.getContent().get(0).getLastName());
    }

    @Test
    public void testFindPaginatedForOwnersLastName_Empty() {
        Page<Owner> page = new PageImpl<>(Collections.emptyList());

        when(owners.findByLastName(any(String.class), any(Pageable.class))).thenReturn(page);

        Page<Owner> result = ownerController.findPaginatedForOwnersLastName(1, "Smith");

        assertEquals(0, result.getTotalElements());
    }
}
