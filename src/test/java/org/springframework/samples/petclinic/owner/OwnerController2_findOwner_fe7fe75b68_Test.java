package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OwnerController2_findOwner_fe7fe75b68_Test {

    @InjectMocks
    OwnerController ownerController = new OwnerController();

    @Mock
    OwnerRepository owners = new OwnerRepository();

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindOwner_WithNullId() {
        Owner result = ownerController.findOwner(null);
        assertTrue(result instanceof Owner);
    }

    @Test
    public void testFindOwner_WithValidId() {
        // TODO: Change the ownerId and ownerName according to your data
        Integer ownerId = 1;
        String ownerName = "John Doe";
        Owner owner = new Owner();
        owner.setId(ownerId);
        owner.setFirstName(ownerName);

        when(owners.findById(any(Integer.class))).thenReturn(java.util.Optional.of(owner));

        Owner result = ownerController.findOwner(ownerId);
        assertEquals(ownerName, result.getFirstName());
    }
}
