package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isNull;

public class OwnerController_findOwner_66dfd5ad88_Test {

    @InjectMocks
    private OwnerController ownerController = new OwnerController();

    @Mock
    private OwnerRepository owners = new OwnerRepository();

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindOwner_NullId() {
        Owner owner = ownerController.findOwner(null);
        assertNotNull(owner);
    }

    @Test
    public void testFindOwner_ValidId() {
        Owner expectedOwner = new Owner();
        expectedOwner.setId(1);
        when(owners.findById(any(Integer.class))).thenReturn(java.util.Optional.of(expectedOwner));

        Owner actualOwner = ownerController.findOwner(1);
        assertEquals(expectedOwner, actualOwner);
    }

    @Test
    public void testFindOwner_InvalidId() {
        when(owners.findById(isNull())).thenReturn(java.util.Optional.empty());

        Owner owner = ownerController.findOwner(999);
        assertEquals(null, owner);
    }
}
