package org.springframework.samples.petclinic.vet;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.samples.petclinic.model.Specialty;

public class Vet_setSpecialtiesInternal_f0b18c7e4f_Test {

    private Vet vet;

    @BeforeEach
    public void setUp() {
        vet = new Vet();
    }

    @Test
    public void testSetSpecialtiesInternal_withNonNullSet() {
        Set<Specialty> specialties = new HashSet<>();
        Specialty specialty = new Specialty();
        specialty.setName("cardiology");
        specialties.add(specialty);

        vet.setSpecialtiesInternal(specialties);
        Assertions.assertEquals(specialties, vet.getSpecialtiesInternal(), "The set of specialties should match the one provided");
    }

    @Test
    public void testSetSpecialtiesInternal_withNullSet() {
        vet.setSpecialtiesInternal(null);
        Assertions.assertNull(vet.getSpecialtiesInternal(), "The set of specialties should be null");
    }

    @Test
    public void testSetSpecialtiesInternal_withEmptySet() {
        Set<Specialty> specialties = new HashSet<>();
        vet.setSpecialtiesInternal(specialties);
        Assertions.assertEquals(specialties, vet.getSpecialtiesInternal(), "The set of specialties should be empty");
    }
}
