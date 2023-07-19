package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class OwnerController_findOwner_fe7fe75b68_Test {

    @Mock
    private OwnerRepository owners;

    @InjectMocks
    private OwnerController ownerController;

    private Owner owner;

    @BeforeEach
    public void setup() {
        owner = new Owner();
        owner.setId(1);
        owner.setFirstName("John");
        owner.setLastName("Doe");
    }

    @Test
    public void testFindOwner_OwnerIdIsNull() {
        Owner actualOwner = ownerController.findOwner(null);
        assertNotNull(actualOwner, "Owner should not be null");
    }

    @Test
    public void testFindOwner_OwnerIdIsNotNull() {
        when(owners.findById(1)).thenReturn(java.util.Optional.of(owner));
        Owner actualOwner = ownerController.findOwner(1);
        assertEquals(owner, actualOwner, "Owners should be equal");
    }
}
