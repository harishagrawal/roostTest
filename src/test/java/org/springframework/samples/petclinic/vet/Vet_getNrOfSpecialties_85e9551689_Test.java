package org.springframework.samples.petclinic.vet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Specialty;
import org.springframework.samples.petclinic.model.Vet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Vet_getNrOfSpecialties_85e9551689_Test {

    private Vet vet;

    @BeforeEach
    public void setUp() {
        this.vet = new Vet();
    }

    @Test
    public void testGetNrOfSpecialtiesWhenNoSpecialties() {
        assertEquals(0, this.vet.getNrOfSpecialties());
    }

    @Test
    public void testGetNrOfSpecialtiesWhenSpecialtiesAdded() {
        Specialty specialty1 = new Specialty();
        this.vet.addSpecialty(specialty1);

        Specialty specialty2 = new Specialty();
        this.vet.addSpecialty(specialty2);

        assertEquals(2, this.vet.getNrOfSpecialties());
    }
}
