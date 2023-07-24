package org.springframework.samples.petclinic.vet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.samples.petclinic.model.Specialty;
import java.util.HashSet;
import java.util.Set;
import static org.mockito.Mockito.*;

public class Vet_getNrOfSpecialties_f8247daaad_Test {

    @InjectMocks
    Vet vet = new Vet();

    @Mock
    Set<Specialty> specialties = new HashSet<>();

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
        vet.setSpecialtiesInternal(specialties);
    }

    @Test
    public void testGetNrOfSpecialties_whenNoSpecialties() {
        when(specialties.size()).thenReturn(0);
        assertEquals(0, vet.getNrOfSpecialties());
    }

    @Test
    public void testGetNrOfSpecialties_whenMultipleSpecialties() {
        when(specialties.size()).thenReturn(3);
        assertEquals(3, vet.getNrOfSpecialties());
    }
}
