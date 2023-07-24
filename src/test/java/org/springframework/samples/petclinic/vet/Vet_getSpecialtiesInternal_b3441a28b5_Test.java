package org.springframework.samples.petclinic.vet;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Specialty;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class Vet_getSpecialtiesInternal_b3441a28b5_Test {

    @InjectMocks
    private Vet vet = new Vet();

    @BeforeEach
    public void setUp() {
        vet.setSpecialtiesInternal(new HashSet<>());
    }

    @Test
    public void testGetSpecialtiesInternalWhenSpecialtiesIsNull() {
        Set<Specialty> specialties = vet.getSpecialtiesInternal();
        assertNotNull(specialties);
        assertTrue(specialties.isEmpty());
    }

    @Test
    public void testGetSpecialtiesInternalWhenSpecialtiesIsNotNull() {
        Set<Specialty> expectedSpecialties = new HashSet<>();
        Specialty specialty = new Specialty();
        expectedSpecialties.add(specialty);

        vet.getSpecialtiesInternal().add(specialty);

        Set<Specialty> actualSpecialties = vet.getSpecialtiesInternal();

        assertNotNull(actualSpecialties);
        assertEquals(expectedSpecialties, actualSpecialties);
    }
}
