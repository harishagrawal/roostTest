package org.springframework.samples.petclinic.vet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Specialty;
import org.springframework.samples.petclinic.model.Vet;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Vet_getNrOfSpecialties_f8247daaad_Test {

    @InjectMocks
    Vet vet;

    @Mock
    Set<Specialty> specialties;

    @BeforeEach
    void setup() {
        specialties = new HashSet<>();
        vet.setSpecialtiesInternal(specialties);
    }

    @Test
    public void testGetNrOfSpecialties_whenSpecialtiesExist() {
        when(specialties.size()).thenReturn(2);
        int nrOfSpecialties = vet.getNrOfSpecialties();
        assertEquals(2, nrOfSpecialties);
    }

    @Test
    public void testGetNrOfSpecialties_whenNoSpecialtiesExist() {
        when(specialties.size()).thenReturn(0);
        int nrOfSpecialties = vet.getNrOfSpecialties();
        assertEquals(0, nrOfSpecialties);
    }
}
