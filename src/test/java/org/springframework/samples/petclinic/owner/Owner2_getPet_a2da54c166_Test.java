package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Pet;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Owner2_getPet_a2da54c166_Test {

    @InjectMocks
    private Owner owner;

    @Mock
    private Pet pet1;

    @Mock
    private Pet pet2;

    @BeforeEach
    void setUp() {
        when(pet1.getName()).thenReturn("Fido");
        when(pet2.getName()).thenReturn("Buddy");
        when(pet1.isNew()).thenReturn(false);
        when(pet2.isNew()).thenReturn(true);
        List<Pet> petList = Arrays.asList(pet1, pet2);
        owner.setPetsInternal(petList);
    }

    @Test
    public void testGetPet_ignoreNew() {
        Pet foundPet = owner.getPet("Fido", true);
        assertNotNull(foundPet);
        assertEquals("Fido", foundPet.getName());
    }

    @Test
    public void testGetPet_notIgnoreNew() {
        Pet foundPet = owner.getPet("Buddy", false);
        assertNotNull(foundPet);
        assertEquals("Buddy", foundPet.getName());
    }

    @Test
    public void testGetPet_notFound() {
        Pet foundPet = owner.getPet("Unknown", true);
        assertNull(foundPet);
    }
}
