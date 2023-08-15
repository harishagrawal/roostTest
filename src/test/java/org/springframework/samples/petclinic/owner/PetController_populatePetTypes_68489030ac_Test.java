package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class PetController_populatePetTypes_68489030ac_Test {

    @MockBean
    private OwnerRepository owners;

    private PetController petController;

    @BeforeEach
    public void setup() {
        petController = new PetController();
    }

    @Test
    public void testPopulatePetTypesSuccess() {
        PetType dog = new PetType();
        dog.setName("Dog");

        PetType cat = new PetType();
        cat.setName("Cat");

        List<PetType> expectedPetTypes = Arrays.asList(dog, cat);

        when(owners.findPetTypes()).thenReturn(expectedPetTypes);

        Collection<PetType> actualPetTypes = petController.populatePetTypes();

        assertEquals(expectedPetTypes, actualPetTypes);
    }

    @Test
    public void testPopulatePetTypesNoData() {
        List<PetType> expectedPetTypes = Arrays.asList();

        when(owners.findPetTypes()).thenReturn(expectedPetTypes);

        Collection<PetType> actualPetTypes = petController.populatePetTypes();

        assertEquals(expectedPetTypes, actualPetTypes);
    }
}
