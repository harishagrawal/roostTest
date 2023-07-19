package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.OwnerRepository;

@ExtendWith(MockitoExtension.class)
public class PetController_findOwner_d0599dbdf3_Test {

    @InjectMocks
    PetController petController;

    @Mock
    OwnerRepository owners;

    @BeforeEach
    public void setup() {
        Owner owner = new Owner();
        owner.setId(1);
        owner.setFirstName("John");
        owner.setLastName("Doe");

        when(owners.findById(1)).thenReturn(java.util.Optional.of(owner));
        when(owners.findById(2)).thenReturn(java.util.Optional.empty());
    }

    @Test
    public void testFindOwner_Success() {
        Owner owner = petController.findOwner(1);
        assertEquals("John", owner.getFirstName());
        assertEquals("Doe", owner.getLastName());
    }

    @Test
    public void testFindOwner_Failure() {
        Owner owner = petController.findOwner(2);
        assertEquals(null, owner);
    }
}
