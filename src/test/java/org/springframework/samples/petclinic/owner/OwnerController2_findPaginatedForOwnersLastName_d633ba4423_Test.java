package org.springframework.samples.petclinic.owner;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OwnerController2_findPaginatedForOwnersLastName_d633ba4423_Test {

    private OwnerRepository owners;
    private OwnerController controller;

    @BeforeEach
    public void setup() {
        owners = mock(OwnerRepository.class);
        controller = new OwnerController(owners);
    }

    @Test
    public void testFindPaginatedForOwnersLastNameSuccess() {
        String lastname = "Smith";
        int page = 1;
        int pageSize = 5;
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        Page<Owner> expected = mock(Page.class);

        when(owners.findByLastName(lastname, pageable)).thenReturn(expected);

        Page<Owner> actual = controller.findPaginatedForOwnersLastName(page, lastname);

        assertEquals(expected, actual);
    }

    @Test
    public void testFindPaginatedForOwnersLastNameFailure() {
        String lastname = "Smith";
        int page = 1;
        int pageSize = 5;
        Pageable pageable = PageRequest.of(page - 1, pageSize);

        when(owners.findByLastName(lastname, pageable)).thenReturn(null);

        Page<Owner> actual = controller.findPaginatedForOwnersLastName(page, lastname);

        assertEquals(null, actual);
    }
}
