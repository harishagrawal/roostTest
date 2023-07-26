package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.service.ClinicService;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class PetController_findOwner_d0599dbdf3_Test {

    @Mock
    ClinicService clinicService;

    @InjectMocks
    PetController petController;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindOwner() {
        Owner owner = new Owner();
        owner.setId(1);
        owner.setFirstName("John");
        owner.setLastName("Doe");

        when(clinicService.findOwnerById(1)).thenReturn(owner);

        Owner foundOwner = petController.findOwner(1);

        assertNotNull(foundOwner);
        assertEquals(1, foundOwner.getId());
        assertEquals("John", foundOwner.getFirstName());
        assertEquals("Doe", foundOwner.getLastName());
    }

    @Test
    public void testFindOwnerNotFound() {
        when(clinicService.findOwnerById(1)).thenReturn(null);

        Owner foundOwner = petController.findOwner(1);

        assertNull(foundOwner);
    }
}
