package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OwnerController2_findPaginatedForOwnersLastName_5e7208e66f_Test {

    @Mock
    private OwnerRepository owners;

    @InjectMocks
    private OwnerController ownerController;

    private List<Owner> ownerList;

    @BeforeEach
    void setup() {
        Owner owner1 = new Owner();
        owner1.setLastName("Smith");

        Owner owner2 = new Owner();
        owner2.setLastName("Johnson");

        ownerList = Arrays.asList(owner1, owner2);
    }

    @Test
    public void testFindPaginatedForOwnersLastName_Success() {
        Pageable pageable = PageRequest.of(0, 5);
        Page<Owner> page = new PageImpl<>(ownerList, pageable, ownerList.size());
        when(owners.findByLastName("Smith", pageable)).thenReturn(page);

        Page<Owner> result = ownerController.findPaginatedForOwnersLastName(1, "Smith");
        
        assertEquals(page, result);
        verify(owners, times(1)).findByLastName("Smith", pageable);
    }

    @Test
    public void testFindPaginatedForOwnersLastName_NoOwnerFound() {
        Pageable pageable = PageRequest.of(0, 5);
        Page<Owner> page = Page.empty();
        when(owners.findByLastName("Doe", pageable)).thenReturn(page);

        Page<Owner> result = ownerController.findPaginatedForOwnersLastName(1, "Doe");

        assertEquals(page, result);
        verify(owners, times(1)).findByLastName("Doe", pageable);
    }
}
