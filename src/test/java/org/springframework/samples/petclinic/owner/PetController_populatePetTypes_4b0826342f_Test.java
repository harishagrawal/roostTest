package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PetController_populatePetTypes_4b0826342f_Test {

    @Mock
    private OwnerRepository owners;

    @InjectMocks
    private PetController petController;

    private PetType petType1;
    private PetType petType2;

    @BeforeEach
    public void setup() {
        petType1 = new PetType();
        petType1.setId(1);
        petType1.setName("Dog");

        petType2 = new PetType();
        petType2.setId(2);
        petType2.setName("Cat");
    }

    @Test
    public void testPopulatePetTypes() {
        when(owners.findPetTypes()).thenReturn(Arrays.asList(petType1, petType2));
        Collection<PetType> petTypes = petController.populatePetTypes();
        assertEquals(2, petTypes.size());
    }

    @Test
    public void testPopulatePetTypes_NoTypes() {
        when(owners.findPetTypes()).thenReturn(Collections.emptyList());
        Collection<PetType> petTypes = petController.populatePetTypes();
        assertEquals(0, petTypes.size());
    }
}
