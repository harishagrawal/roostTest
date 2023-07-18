package org.springframework.samples.petclinic.owner;

import java.util.ArrayList;
import java.util.List;
import org.springframework.samples.petclinic.model.Person;
import org.springframework.util.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
public class Owner_getPet_7a4d72b0e8_Test {

    @Mock
    private Owner owner;

    private Pet pet1;
    private Pet pet2;

    @BeforeEach
    public void setup() {
        pet1 = new Pet();
        pet1.setId(1);
        pet1.setName("Fido");

        pet2 = new Pet();
        pet2.setId(2);
        pet2.setName("Buddy");

        List<Pet> pets = new ArrayList<>();
        pets.add(pet1);
        pets.add(pet2);

        when(owner.getPets()).thenReturn(pets);
    }

    @Test
    public void testGetPet_success() {
        // Test for pet1
        Pet result1 = owner.getPet("Fido", true);
        assertEquals(pet1, result1);

        // Test for pet2
        Pet result2 = owner.getPet("Buddy", true);
        assertEquals(pet2, result2);
    }

    @Test
    public void testGetPet_failure() {
        // Test for non-existing pet
        Pet result = owner.getPet("Non-Existing", true);
        assertNull(result);
    }
}
