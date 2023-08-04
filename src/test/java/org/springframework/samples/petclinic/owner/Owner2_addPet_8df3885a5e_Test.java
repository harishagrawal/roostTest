package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Pet;

public class Owner2_addPet_8df3885a5e_Test {

    private Owner owner;
    private Pet petMock;

    @BeforeEach
    public void setup() {
        owner = new Owner();
        petMock = mock(Pet.class);
    }

    @Test
    public void testAddPet_NewPet() {
        when(petMock.isNew()).thenReturn(true);

        owner.addPet(petMock);

        assertEquals(1, owner.getPets().size());
        assertEquals(petMock, owner.getPets().get(0));
    }

    @Test
    public void testAddPet_ExistingPet() {
        when(petMock.isNew()).thenReturn(false);

        owner.addPet(petMock);

        assertEquals(0, owner.getPets().size());
    }
}
