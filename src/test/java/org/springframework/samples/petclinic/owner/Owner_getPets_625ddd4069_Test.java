package org.springframework.samples.petclinic.owner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Owner_getPets_625ddd4069_Test {

    @InjectMocks
    private Owner owner;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        Pet pet1 = new Pet();
        pet1.setName("Fido");
        Pet pet2 = new Pet();
        pet2.setName("Rex");
        owner.setPets(Arrays.asList(pet1, pet2));
    }

    @Test
    public void testGetPets() {
        List<Pet> pets = owner.getPets();
        assertEquals(2, pets.size());
        assertEquals("Fido", pets.get(0).getName());
        assertEquals("Rex", pets.get(1).getName());
    }

    @Test
    public void testGetPetsWhenNoPets() {
        owner.setPets(null);
        List<Pet> pets = owner.getPets();
        assertEquals(null, pets);
    }
}
