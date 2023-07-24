package org.springframework.samples.petclinic.owner;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.samples.petclinic.model.Pet;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class Owner2_getPets_625ddd4069_Test {

    @Mock
    private Owner owner;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetPets() {
        List<Pet> mockPets = new ArrayList<>();
        Pet pet1 = new Pet();
        pet1.setName("Fido");
        mockPets.add(pet1);
        Pet pet2 = new Pet();
        pet2.setName("Buddy");
        mockPets.add(pet2);

        when(owner.getPets()).thenReturn(mockPets);

        List<Pet> pets = owner.getPets();
        assertEquals(2, pets.size());
        assertEquals("Fido", pets.get(0).getName());
        assertEquals("Buddy", pets.get(1).getName());
    }

    @Test
    public void testGetPetsEmpty() {
        List<Pet> mockPets = new ArrayList<>();
        when(owner.getPets()).thenReturn(mockPets);

        List<Pet> pets = owner.getPets();
        assertEquals(0, pets.size());
    }
}
