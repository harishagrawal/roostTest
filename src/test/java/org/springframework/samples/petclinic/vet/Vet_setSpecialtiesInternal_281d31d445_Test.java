package org.springframework.samples.petclinic.vet;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Specialty;

public class Vet_setSpecialtiesInternal_281d31d445_Test {

    private Vet vet;
    private Set<Specialty> specialties;

    @BeforeEach
    public void setup() {
        this.vet = new Vet();
        this.specialties = new HashSet<>();
        Specialty specialty = new Specialty();
        specialty.setName("surgery");
        this.specialties.add(specialty);
    }

    @Test
    public void testSetSpecialtiesInternal_Success() {
        this.vet.setSpecialtiesInternal(this.specialties);
        Assertions.assertEquals(this.specialties, this.vet.getSpecialtiesInternal());
    }

    @Test
    public void testSetSpecialtiesInternal_Null() {
        this.vet.setSpecialtiesInternal(null);
        Assertions.assertNull(this.vet.getSpecialtiesInternal());
    }
}
