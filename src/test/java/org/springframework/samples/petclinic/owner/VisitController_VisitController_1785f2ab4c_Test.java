package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class VisitController_VisitController_1785f2ab4c_Test {

    @InjectMocks
    VisitController visitController;

    @Mock
    OwnerRepository ownerRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testVisitControllerWithValidOwner() {
        Owner owner = new Owner();
        owner.setId(1);
        when(ownerRepository.findById(1)).thenReturn(java.util.Optional.of(owner));

        assertEquals(visitController.getOwners(), ownerRepository);
    }

    @Test
    public void testVisitControllerWithNullOwner() {
        when(ownerRepository.findById(1)).thenReturn(java.util.Optional.empty());

        assertEquals(visitController.getOwners(), ownerRepository);
    }
}
