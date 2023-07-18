package org.springframework.samples.petclinic.owner;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;

@SpringBootTest
public class OwnerController_findPaginatedForOwnersLastName_d633ba4423_Test {

    @MockBean
    private OwnerRepository owners;

    @MockBean
    private OwnerController ownerController;

    @Test
    public void testFindPaginatedForOwnersLastName_ValidLastName() {
        List<Owner> ownerList = new ArrayList<>();
        ownerList.add(new Owner());
        ownerList.add(new Owner());
        Page<Owner> ownerPage = new PageImpl<>(ownerList);

        Mockito.when(owners.findByLastName(anyString(), any(Pageable.class))).thenReturn(ownerPage);

        Page<Owner> result = ownerController.findPaginatedForOwnersLastName(1, "Smith");

        assertEquals(ownerPage, result);
        assertEquals(2, result.getContent().size());
    }

    @Test
    public void testFindPaginatedForOwnersLastName_EmptyLastName() {
        List<Owner> ownerList = new ArrayList<>();
        Page<Owner> ownerPage = new PageImpl<>(ownerList);

        Mockito.when(owners.findByLastName(anyString(), any(Pageable.class))).thenReturn(ownerPage);

        Page<Owner> result = ownerController.findPaginatedForOwnersLastName(1, "");

        assertEquals(ownerPage, result);
        assertTrue(result.getContent().isEmpty());
    }

    @Test
    public void testFindPaginatedForOwnersLastName_NullLastName() {
        List<Owner> ownerList = new ArrayList<>();
        Page<Owner> ownerPage = new PageImpl<>(ownerList);

        Mockito.when(owners.findByLastName(anyString(), any(Pageable.class))).thenReturn(ownerPage);

        Page<Owner> result = ownerController.findPaginatedForOwnersLastName(1, null);

        assertEquals(ownerPage, result);
        assertTrue(result.getContent().isEmpty());
    }

    @Test
    public void testFindPaginatedForOwnersLastName_InvalidPageNumber() {
        List<Owner> ownerList = new ArrayList<>();
        Page<Owner> ownerPage = new PageImpl<>(ownerList);

        Mockito.when(owners.findByLastName(anyString(), any(Pageable.class))).thenReturn(ownerPage);

        Page<Owner> result = ownerController.findPaginatedForOwnersLastName(-1, "Smith");

        assertEquals(ownerPage, result);
        assertTrue(result.getContent().isEmpty());
    }
}
