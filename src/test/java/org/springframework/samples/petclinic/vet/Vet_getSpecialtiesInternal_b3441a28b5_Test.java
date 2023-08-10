package org.springframework.samples.petclinic.vet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.samples.petclinic.model.Specialty;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Vet_getSpecialtiesInternal_b3441a28b5_Test {

    private Vet vet;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        vet = new Vet();
    }

    @Test
    public void testGetSpecialtiesInternalWhenSpecialtiesIsNull() {
        Set<Specialty> specialties = vet.getSpecialtiesInternal();
        assertEquals(0, specialties.size(), "Expected an empty set of specialties");
    }

    @Test
    public void testGetSpecialtiesInternalWhenSpecialtiesIsNotNull() {
        Set<Specialty> specialtiesSet = new HashSet<>();
        Specialty specialty = new Specialty();
        specialty.setName("surgery");
        specialtiesSet.add(specialty);
        vet.setSpecialtiesInternal(specialtiesSet);

        Set<Specialty> specialties = vet.getSpecialtiesInternal();
        assertEquals(1, specialties.size(), "Expected a set of specialties containing one element");
        assertEquals("surgery", specialties.iterator().next().getName(), "Expected the specialty name to be 'surgery'");
    }
}
