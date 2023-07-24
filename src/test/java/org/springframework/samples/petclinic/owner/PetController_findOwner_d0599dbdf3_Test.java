package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

public class PetController_findOwner_d0599dbdf3_Test {

    @InjectMocks
    PetController petController = new PetController();

    @Mock
    OwnerRepository owners = new OwnerRepository();

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindOwner_success() {
        Owner owner = new Owner();
        owner.setId(1);
        owner.setFirstName("John");
        owner.setLastName("Doe");

        when(owners.findById(1)).thenReturn(owner);

        Owner result = petController.findOwner(1);
        assertEquals(owner, result);
    }

    @Test
    public void testFindOwner_failure() {
        when(owners.findById(1)).thenReturn(null);

        Owner result = petController.findOwner(1);
        assertNull(result);
    }
}
