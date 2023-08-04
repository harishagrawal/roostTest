package org.springframework.samples.petclinic.vet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Specialty;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class Vet_addSpecialty_48ee2c4400_Test {

    @InjectMocks
    Vet vet;

    @Mock
    Specialty specialty;

    @BeforeEach
    public void setUp() {
        vet = new Vet();
    }

    @Test
    public void testAddSpecialty() {
        vet.addSpecialty(specialty);
        assertTrue(vet.getSpecialtiesInternal().contains(specialty));
    }

    @Test
    public void testAddSpecialty_Null() {
        assertThrows(NullPointerException.class, () -> {
            vet.addSpecialty(null);
        });
    }
}
