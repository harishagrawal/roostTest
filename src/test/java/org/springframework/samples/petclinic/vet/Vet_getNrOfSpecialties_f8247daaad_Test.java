package org.springframework.samples.petclinic.vet;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.samples.petclinic.vet.Vet;
import org.springframework.samples.petclinic.vet.Specialty;

public class Vet_getNrOfSpecialties_f8247daaad_Test {
    private Vet vet;

    @BeforeEach
    public void setup() {
        vet = new Vet();
    }

    @Test
    public void testGetNrOfSpecialties_WithEmptySpecialties() {
        Set<Specialty> specialties = Collections.emptySet();
        vet.setSpecialtiesInternal(specialties);
        int nrOfSpecialties = vet.getNrOfSpecialties();
        Assertions.assertEquals(0, nrOfSpecialties, "Number of specialties should be 0 when there are no specialties");
    }

    @Test
    public void testGetNrOfSpecialties_WithNonEmptySpecialties() {
        Set<Specialty> specialties = new HashSet<>();
        Specialty specialty1 = new Specialty();
        Specialty specialty2 = new Specialty();
        specialties.add(specialty1);
        specialties.add(specialty2);
        vet.setSpecialtiesInternal(specialties);
        int nrOfSpecialties = vet.getNrOfSpecialties();
        Assertions.assertEquals(2, nrOfSpecialties, "Number of specialties should be equal to the size of the specialties set");
    }
}
