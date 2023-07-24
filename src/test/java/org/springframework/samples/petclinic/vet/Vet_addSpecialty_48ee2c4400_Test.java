package org.springframework.samples.petclinic.vet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.samples.petclinic.model.Specialty;
import org.springframework.samples.petclinic.vet.Vet;

import static org.junit.jupiter.api.Assertions.*;

public class Vet_addSpecialty_48ee2c4400_Test {

    private Vet vet;
    private Specialty specialty;

    @BeforeEach
    public void setup() {
        this.vet = new Vet();
        this.specialty = Mockito.mock(Specialty.class);
    }

    @Test
    public void testAddSpecialtySuccess() {
        this.vet.addSpecialty(this.specialty);
        assertTrue(this.vet.getSpecialties().contains(this.specialty));
    }

    @Test
    public void testAddSpecialtyFailure() {
        Specialty nullSpecialty = null;
        assertThrows(NullPointerException.class, () -> this.vet.addSpecialty(nullSpecialty));
    }

    @Test
    public void testAddSpecialtyDuplicate() {
        this.vet.addSpecialty(this.specialty);
        this.vet.addSpecialty(this.specialty);
        assertEquals(1, this.vet.getSpecialties().size());
    }
}
