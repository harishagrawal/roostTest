package org.springframework.samples.petclinic.owner;

import java.util.ArrayList;
import java.util.List;
import org.springframework.samples.petclinic.model.Person;
import org.springframework.util.Assert;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class Owner2_getPet_7a4d72b0e8_Test {

    @Mock
    private Owner owner;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetPetSuccess() {
        Pet pet1 = new Pet();
        pet1.setId(1);
        Pet pet2 = new Pet();
        pet2.setId(2);

        List<Pet> petList = new ArrayList<>();
        petList.add(pet1);
        petList.add(pet2);

        when(owner.getPets()).thenReturn(petList);

        Pet result = owner.getPet("pet1");
        assertNotNull(result);
        assertEquals(1, result.getId());
    }

    @Test
    void testGetPetFailure() {
        Pet pet1 = new Pet();
        pet1.setId(1);
        Pet pet2 = new Pet();
        pet2.setId(2);

        List<Pet> petList = new ArrayList<>();
        petList.add(pet1);
        petList.add(pet2);

        when(owner.getPets()).thenReturn(petList);

        Pet result = owner.getPet("pet3");
        assertNull(result);
    }
}
