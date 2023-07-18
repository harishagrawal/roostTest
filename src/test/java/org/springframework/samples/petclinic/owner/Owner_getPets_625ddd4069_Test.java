package org.springframework.samples.petclinic.owner;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class Owner_getPets_625ddd4069_Test {

    @InjectMocks
    Owner owner = new Owner();

    @Mock
    List<Pet> pets = new ArrayList<>();

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetPets() {
        Pet pet1 = new Pet();
        pet1.setName("Buddy");
        Pet pet2 = new Pet();
        pet2.setName("Milo");

        pets.add(pet1);
        pets.add(pet2);

        when(owner.getPets()).thenReturn(pets);

        List<Pet> result = owner.getPets();

        assertEquals(2, result.size());
        assertEquals("Buddy", result.get(0).getName());
        assertEquals("Milo", result.get(1).getName());
    }

    @Test
    public void testGetPets_emptyList() {

        when(owner.getPets()).thenReturn(pets);

        List<Pet> result = owner.getPets();

        assertEquals(0, result.size());
    }
}
