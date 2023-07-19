package org.springframework.samples.petclinic.vet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.vet.Specialty;
import org.springframework.samples.petclinic.vet.Vet;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
public class Vet_setSpecialtiesInternal_281d31d445_Test {

    private Vet vet;

    @BeforeEach
    public void setUp() {
        this.vet = new Vet();
    }

    @Test
    public void testSetSpecialtiesInternal() {
        Set<Specialty> specialties = new HashSet<>();
        Specialty specialty1 = new Specialty();
        specialty1.setName("surgery");
        specialties.add(specialty1);

        Specialty specialty2 = new Specialty();
        specialty2.setName("dentistry");
        specialties.add(specialty2);

        this.vet.setSpecialtiesInternal(specialties);

        assertEquals(specialties, this.vet.getSpecialtiesInternal());
    }

    @Test
    public void testSetSpecialtiesInternalWithNull() {
        this.vet.setSpecialtiesInternal(null);
        assertNull(this.vet.getSpecialtiesInternal());
    }
}
