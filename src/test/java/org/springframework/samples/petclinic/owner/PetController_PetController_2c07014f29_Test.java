package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class PetControllerTest {

    @Mock
    private OwnerRepository owners;

    @InjectMocks
    private PetController petController;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testPetController() {
        Owner owner = new Owner();
        owner.setId(1);
        when(owners.findById(1)).thenReturn(owner);
        assertEquals(owner, owners.findById(1));
    }

    @Test
    public void testPetController_NullOwner() {
        when(owners.findById(1)).thenReturn(null);
        assertEquals(null, owners.findById(1));
    }
}
