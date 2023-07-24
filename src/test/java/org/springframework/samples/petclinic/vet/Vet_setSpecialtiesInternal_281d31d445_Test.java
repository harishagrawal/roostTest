package org.springframework.samples.petclinic.vet;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.vet.Specialty;
import org.springframework.samples.petclinic.vet.Vet;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class Vet_setSpecialtiesInternal_281d31d445_Test {

    private Vet vet;

    @BeforeEach
    public void setup() {
        vet = new Vet();
    }

    @Test
    public void testSetSpecialtiesInternal() {
        Set<Specialty> specialties = new HashSet<>();
        Specialty specialty = new Specialty();
        specialty.setName("Cardiology");
        specialties.add(specialty);

        vet.setSpecialtiesInternal(specialties);
        assertEquals(specialties, vet.getSpecialtiesInternal(), "The setSpecialtiesInternal method should set the specialties correctly.");
    }

    @Test
    public void testSetSpecialtiesInternal_EmptySet() {
        Set<Specialty> specialties = new HashSet<>();

        vet.setSpecialtiesInternal(specialties);
        assertEquals(specialties, vet.getSpecialtiesInternal(), "The setSpecialtiesInternal method should handle empty set correctly.");
    }
}
