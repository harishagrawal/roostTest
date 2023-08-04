package org.springframework.samples.petclinic.vet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Specialty;
import org.springframework.samples.petclinic.model.Vet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Vet_getNrOfSpecialties_f8247daaad_Test {

    private Vet vet;

    @BeforeEach
    public void setUp() {
        this.vet = new Vet();
    }

    @Test
    public void testGetNrOfSpecialties_WhenNoSpecialties() {
        assertEquals(0, this.vet.getNrOfSpecialties());
    }

    @Test
    public void testGetNrOfSpecialties_WhenSingleSpecialty() {
        Specialty specialty = new Specialty();
        specialty.setName("surgery");
        this.vet.addSpecialty(specialty);
        assertEquals(1, this.vet.getNrOfSpecialties());
    }

    @Test
    public void testGetNrOfSpecialties_WhenMultipleSpecialties() {
        Specialty specialty1 = new Specialty();
        specialty1.setName("surgery");
        this.vet.addSpecialty(specialty1);

        Specialty specialty2 = new Specialty();
        specialty2.setName("dentistry");
        this.vet.addSpecialty(specialty2);

        assertEquals(2, this.vet.getNrOfSpecialties());
    }
}
