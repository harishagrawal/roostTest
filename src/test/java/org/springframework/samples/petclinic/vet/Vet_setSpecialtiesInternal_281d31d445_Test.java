package org.springframework.samples.petclinic.vet;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Specialty;
import org.springframework.samples.petclinic.model.Vet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Vet_setSpecialtiesInternal_281d31d445_Test {

    private Vet vet;

    @BeforeEach
    public void setup() {
        vet = new Vet();
    }

    @Test
    public void testSetSpecialtiesInternal_withValidSet() {
        Set<Specialty> specialties = new HashSet<>();
        Specialty specialty = new Specialty();
        specialty.setName("surgery");
        specialties.add(specialty);

        vet.setSpecialtiesInternal(specialties);

        assertEquals(specialties, vet.getSpecialtiesInternal(), "setSpecialtiesInternal should set the specialties correctly");
    }

    @Test
    public void testSetSpecialtiesInternal_withNullSet() {
        vet.setSpecialtiesInternal(null);

        assertEquals(0, vet.getSpecialtiesInternal().size(), "setSpecialtiesInternal should initialize an empty set when null is passed");
    }
}
