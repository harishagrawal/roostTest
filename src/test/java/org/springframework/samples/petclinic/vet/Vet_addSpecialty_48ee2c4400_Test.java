package org.springframework.samples.petclinic.vet;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Specialty;

public class Vet_addSpecialty_48ee2c4400_Test {
    private Vet vet;
    private Specialty mockSpecialty;

    @BeforeEach
    public void setup() {
        vet = new Vet();
        mockSpecialty = mock(Specialty.class);
    }

    @Test
    public void testAddSpecialty() {
        assertFalse(vet.getSpecialties().contains(mockSpecialty));
        vet.addSpecialty(mockSpecialty);
        assertTrue(vet.getSpecialties().contains(mockSpecialty));
    }

    @Test
    public void testAddSpecialty_Null() {
        Specialty nullSpecialty = null;
        try {
            vet.addSpecialty(nullSpecialty);
        } catch (NullPointerException e) {
            assertTrue(true);
        }
    }
}
