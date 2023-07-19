package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.util.Assert;

@ExtendWith(MockitoExtension.class)
public class Owner_getPet_7a4d72b0e8_Test {

    private Owner owner;
    private Pet pet1;
    private Pet pet2;

    @BeforeEach
    public void setup() {
        owner = new Owner();
        pet1 = new Pet();
        pet2 = new Pet();

        pet1.setId(1);
        pet2.setId(2);

        pet1.setName("Pet1");
        pet2.setName("Pet2");

        owner.addPet(pet1);
        owner.addPet(pet2);
    }

    @Test
    public void testGetPet() {
        Pet actualPet = owner.getPet("Pet1", true);
        Assert.isTrue(actualPet.equals(pet1), "Expected pet1 but got different pet");

        actualPet = owner.getPet("Pet2", true);
        Assert.isTrue(actualPet.equals(pet2), "Expected pet2 but got different pet");
    }

    @Test
    public void testGetPetWithNonExistingId() {
        Pet actualPet = owner.getPet("Pet3", true);
        Assert.isNull(actualPet, "Expected null but got a pet");
    }
}
