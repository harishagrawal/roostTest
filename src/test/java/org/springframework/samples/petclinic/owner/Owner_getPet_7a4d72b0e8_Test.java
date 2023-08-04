package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.util.Assert;

public class Owner_getPet_7a4d72b0e8_Test {
    private Owner owner;
    private Pet pet1;
    private Pet pet2;

    @BeforeEach
    public void setup() {
        owner = new Owner();
        pet1 = Mockito.mock(Pet.class);
        pet2 = Mockito.mock(Pet.class);

        Mockito.when(pet1.isNew()).thenReturn(false);
        Mockito.when(pet2.isNew()).thenReturn(false);
        Mockito.when(pet1.getId()).thenReturn(1);
        Mockito.when(pet2.getId()).thenReturn(2);

        owner.addPet(pet1);
        owner.addPet(pet2);
    }

    @Test
    public void testGetPet() {
        Pet foundPet = owner.getPet("pet1");
        Assert.notNull(foundPet, "Pet should not be null");
        Assert.isTrue(foundPet.getId().equals(1), "Found pet id should be 1");

        foundPet = owner.getPet("pet2");
        Assert.notNull(foundPet, "Pet should not be null");
        Assert.isTrue(foundPet.getId().equals(2), "Found pet id should be 2");
    }

    @Test
    public void testGetPet_NotFound() {
        Pet foundPet = owner.getPet("pet3");
        Assert.isNull(foundPet, "Pet should be null");
    }
}
