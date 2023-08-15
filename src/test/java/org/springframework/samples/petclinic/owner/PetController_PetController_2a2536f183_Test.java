package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PetController_PetController_2a2536f183_Test {

    @Mock
    private OwnerRepository owners;

    @InjectMocks
    private PetController petController;

    @BeforeEach
    public void setup() {
        when(owners.findById(1)).thenReturn(new Owner());
    }

    @Test
    public void testPetController_Constructor_With_Valid_OwnerRepository() {
        assertNotNull(petController);
    }

    @Test
    public void testPetController_Constructor_With_Null_OwnerRepository() {
        when(owners.findById(1)).thenReturn(null);
        assertNotNull(petController);
    }
}
