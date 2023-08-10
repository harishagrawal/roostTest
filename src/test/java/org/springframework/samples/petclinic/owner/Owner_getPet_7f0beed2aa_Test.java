package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.samples.petclinic.model.Pet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

public class Owner_getPet_7f0beed2aa_Test {

    @InjectMocks
    private Owner owner;

    @Mock
    private Pet fido;

    @Mock
    private Pet rex;

    @BeforeEach
    public void setup() {
        owner = new Owner();
        fido = new Pet();
        rex = new Pet();
        MockitoAnnotations.initMocks(this);
        when(fido.getName()).thenReturn("Fido");
        when(rex.getName()).thenReturn("Rex");

        owner.addPet(fido);
        owner.addPet(rex);
    }

    @Test
    public void testGetPet_success() {
        Pet pet = owner.getPet("Fido");
        assertEquals(fido, pet);
    }

    @Test
    public void testGetPet_failure() {
        Pet pet = owner.getPet("NotAPetName");
        assertNull(pet);
    }
}
