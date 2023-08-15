package org.springframework.samples.petclinic.owner;

import java.util.ArrayList;
import java.util.List;
import org.springframework.samples.petclinic.model.Pet;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

public class Owner2_getPets_4c451435ac_Test {

    @InjectMocks
    Owner owner = new Owner();

    @Mock
    List<Pet> pets;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetPets() {
        Pet pet1 = new Pet();
        pet1.setName("Dog");
        Pet pet2 = new Pet();
        pet2.setName("Cat");

        List<Pet> petList = new ArrayList<>();
        petList.add(pet1);
        petList.add(pet2);

        owner.setPets(petList);

        List<Pet> result = owner.getPets();
        org.junit.Assert.assertNotNull("Pets list should not be null", result);
        org.junit.Assert.assertEquals("Pets list size should be 2", 2, result.size());
        org.junit.Assert.assertEquals("First pet should be Dog", "Dog", result.get(0).getName());
        org.junit.Assert.assertEquals("Second pet should be Cat", "Cat", result.get(1).getName());
    }

    @Test
    public void testGetPets_noPets() {
        List<Pet> petList = new ArrayList<>();

        owner.setPets(petList);

        List<Pet> result = owner.getPets();
        org.junit.Assert.assertNotNull("Pets list should not be null", result);
        org.junit.Assert.assertEquals("Pets list should be empty", 0, result.size());
    }
}
