package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class OwnerController_findOwner_fe7fe75b68_Test {

    @InjectMocks
    private OwnerController ownerController;

    @Mock
    private OwnerRepository owners;

    private Owner owner;

    @BeforeEach
    public void setup() {
        owner = new Owner();
        owner.setId(1);
        owner.setFirstName("John");
        owner.setLastName("Doe");
    }

    @Test
    public void testFindOwner_WithExistingOwnerId() {
        when(owners.findById(1)).thenReturn(java.util.Optional.of(owner));

        Owner result = ownerController.findOwner(1);

        assertNotNull(result, "Owner should not be null");
        assertEquals(1, result.getId(), "Owner id should be 1");
        assertEquals("John", result.getFirstName(), "Owner first name should be John");
        assertEquals("Doe", result.getLastName(), "Owner last name should be Doe");
    }

    @Test
    public void testFindOwner_WithNullOwnerId() {
        when(owners.findById(null)).thenReturn(java.util.Optional.empty());

        Owner result = ownerController.findOwner(null);

        assertNotNull(result, "Owner should not be null");
        assertEquals(null, result.getId(), "Owner id should be null");
    }
}
