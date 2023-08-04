package org.springframework.samples.petclinic.vet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Specialty;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class Vet_getSpecialtiesInternal_b3441a28b5_Test {

    private Vet vet;

    @BeforeEach
    public void setup() {
        vet = new Vet();
    }

    @Test
    public void testGetSpecialtiesInternal_WhenSpecialtiesIsNull() {
        Set<Specialty> specialties = vet.getSpecialtiesInternal();
        assertNotNull(specialties, "Specialties must not be null");
        assertEquals(0, specialties.size(), "Specialties size must be zero");
    }

    @Test
    public void testGetSpecialtiesInternal_WhenSpecialtiesIsNotNull() {
        Specialty specialty = new Specialty();
        specialty.setName("test");
        Set<Specialty> specialtySet = new HashSet<>();
        specialtySet.add(specialty);
        vet.setSpecialtiesInternal(specialtySet);

        Set<Specialty> specialties = vet.getSpecialtiesInternal();
        assertNotNull(specialties, "Specialties must not be null");
        assertEquals(1, specialties.size(), "Specialties size must be one");
        assertEquals("test", specialties.iterator().next().getName(), "Specialty name must be 'test'");
    }
}
