package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class OwnerController_findPaginatedForOwnersLastName_d633ba4423_Test {

    @Mock
    private OwnerRepository owners;

    @BeforeEach
    public void setup() {
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

        Page<Owner> result = findPaginatedForOwnersLastName(1, "Smith");

        assertEquals(page, result);
    }

    @Test
    public void testFindPaginatedForOwnersLastName_NoOwnersFound() {
        Pageable pageable = PageRequest.of(0, 5);
        Page<Owner> page = Page.empty();

        when(owners.findByLastName("Doe", pageable)).thenReturn(page);

        Page<Owner> result = findPaginatedForOwnersLastName(1, "Doe");

        assertEquals(page, result);
    }

    private Page<Owner> findPaginatedForOwnersLastName(int page, String lastname) {
        int pageSize = 5;
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        return owners.findByLastName(lastname, pageable);
    }
}
