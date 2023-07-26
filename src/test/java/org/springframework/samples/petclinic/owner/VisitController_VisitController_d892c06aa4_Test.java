package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.samples.petclinic.model.Owner;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class VisitController_VisitController_d892c06aa4_Test {

    private OwnerRepository ownerRepository;
    private VisitController visitController;

    @BeforeEach
    public void setup() {
        ownerRepository = Mockito.mock(OwnerRepository.class);
        visitController = new VisitController(ownerRepository);
    }

    @Test
    public void testVisitController() {
        Owner owner = new Owner();
        owner.setId(1);
        when(ownerRepository.findById(1)).thenReturn(owner);

        Owner actualOwner = ownerRepository.findById(1);
        assertNotNull(actualOwner, "Owner should not be null");
    }

    @Test
    public void testVisitController_NullOwner() {
        when(ownerRepository.findById(1)).thenReturn(null);

        Owner actualOwner = ownerRepository.findById(1);
        assertNotNull(actualOwner, "Owner should not be null");
    }
}
