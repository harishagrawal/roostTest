package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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
public class OwnerController_findPaginatedForOwnersLastName_d633ba4423_Test {

    @InjectMocks
    private OwnerController ownerController;

    @Mock
    private OwnerRepository owners;

    private String lastName = "Smith";
    private int page = 1;

    @BeforeEach
    void setup() {
        Page<Owner> ownerPage = mockOwnerPage();
        when(owners.findByLastName(eq(lastName), any(Pageable.class))).thenReturn(ownerPage);
    }

    @Test
    void testFindPaginatedForOwnersLastName_ValidInput() {
        Page<Owner> result = ownerController.findPaginatedForOwnersLastName(page, lastName);
        assertEquals(5, result.getSize());
    }

    @Test
    void testFindPaginatedForOwnersLastName_InvalidInput() {
        Page<Owner> result = ownerController.findPaginatedForOwnersLastName(-1, lastName);
        assertEquals(0, result.getSize());
    }

    private Page<Owner> mockOwnerPage() {
        Owner owner1 = new Owner();
        Owner owner2 = new Owner();
        Owner owner3 = new Owner();
        Owner owner4 = new Owner();
        Owner owner5 = new Owner();
        List<Owner> owners = Arrays.asList(owner1, owner2, owner3, owner4, owner5);
        return new PageImpl<>(owners, PageRequest.of(page, 5), owners.size());
    }
}
