package org.springframework.samples.petclinic.vet;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class Vet_getSpecialtiesInternal_ce2cc1ae59_Test {

    @InjectMocks
    private Vet vet;

    @Mock
    private Specialty specialty;

    @BeforeEach
    public void setup() {
        Set<Specialty> specialties = new HashSet<>();
        specialties.add(specialty);
        vet.setSpecialtiesInternal(specialties);
    }

    @Test
    public void testGetSpecialtiesInternal_Success() {
        Set<Specialty> expectedSpecialties = new HashSet<>();
        expectedSpecialties.add(specialty);
        Set<Specialty> actualSpecialties = vet.getSpecialtiesInternal();
        assertEquals(expectedSpecialties, actualSpecialties);
    }

    @Test
    public void testGetSpecialtiesInternal_NullSet() {
        Vet vet = new Vet();
        Set<Specialty> expectedSpecialties = new HashSet<>();
        Set<Specialty> actualSpecialties = vet.getSpecialtiesInternal();
        assertEquals(expectedSpecialties, actualSpecialties);
    }
}
