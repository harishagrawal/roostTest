package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.service.ClinicService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PetController_findOwner_d0599dbdf3_Test {

    @Mock
    private ClinicService clinicService;

    @InjectMocks
    private PetController petController;

    private Owner owner;

    @BeforeEach
    public void setup() {
        owner = new Owner();
        owner.setId(1);
        owner.setFirstName("John");
        owner.setLastName("Doe");
    }

    @Test
    public void testFindOwner() {
        when(clinicService.findOwnerById(1)).thenReturn(owner);

        Owner foundOwner = petController.findOwner(1);

        assertNotNull(foundOwner, "Owner should not be null");
        assertEquals(owner.getId(), foundOwner.getId(), "Owner IDs should match");
        assertEquals(owner.getFirstName(), foundOwner.getFirstName(), "Owner first names should match");
        assertEquals(owner.getLastName(), foundOwner.getLastName(), "Owner last names should match");
    }

    @Test
    public void testFindOwner_NotFound() {
        when(clinicService.findOwnerById(1)).thenReturn(null);

        Owner foundOwner = petController.findOwner(1);

        assertEquals(null, foundOwner, "Owner should be null");
    }
}
