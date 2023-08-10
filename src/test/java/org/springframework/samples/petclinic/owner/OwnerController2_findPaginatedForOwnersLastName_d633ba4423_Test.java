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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OwnerController2_findPaginatedForOwnersLastName_d633ba4423_Test {

    @Mock
    private OwnerRepository owners;

    @InjectMocks
    private OwnerController ownerController;

    private List<Owner> ownerList;
    private Page<Owner> ownerPage;

    @BeforeEach
    public void setup() {
        Owner owner1 = new Owner();
        owner1.setLastName("Smith");
        Owner owner2 = new Owner();
        owner2.setLastName("Smith");
        ownerList = Arrays.asList(owner1, owner2);
        ownerPage = new PageImpl<>(ownerList);
    }

    @Test
    public void testFindPaginatedForOwnersLastName_success() {
        when(owners.findByLastName(eq("Smith"), any(Pageable.class))).thenReturn(ownerPage);

        Page<Owner> returnedPage = ownerController.findPaginatedForOwnersLastName(1, "Smith");

        assertEquals(ownerPage, returnedPage);
        assertEquals(ownerList, returnedPage.getContent());
    }

    @Test
    public void testFindPaginatedForOwnersLastName_noOwners() {
        when(owners.findByLastName(eq("Nonexistent"), any(Pageable.class))).thenReturn(Page.empty());

        Page<Owner> returnedPage = ownerController.findPaginatedForOwnersLastName(1, "Nonexistent");

        assertEquals(Page.empty(), returnedPage);
    }
}
