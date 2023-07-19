package org.springframework.samples.petclinic.vet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Specialty;

public class Vet_addSpecialty_48ee2c4400_Test {
    
    private Vet vet;
    private Specialty specialty;

    @BeforeEach
    public void setup() {
        this.vet = new Vet();
        this.specialty = mock(Specialty.class);
    }

    @Test
    public void testAddSpecialty_Success() {
        this.vet.addSpecialty(this.specialty);

        Set<Specialty> specialties = new HashSet<>();
        specialties.add(this.specialty);
        
        assertEquals(specialties, this.vet.getSpecialties());
    }

    @Test
    public void testAddSpecialty_Null() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            this.vet.addSpecialty(null);
        });

        String expectedMessage = "Specialty cannot be null";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }
}
