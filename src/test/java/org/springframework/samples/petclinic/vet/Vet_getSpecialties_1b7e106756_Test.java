package org.springframework.samples.petclinic.vet;

import java.util.HashSet;
import java.util.Set;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Specialty;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Vet_getSpecialties_1b7e106756_Test {

    @InjectMocks
    Vet vet = new Vet();

    @Mock
    Specialty specialty1 = new Specialty();

    @Mock
    Specialty specialty2 = new Specialty();

    @BeforeEach
    void setUp() {
        Set<Specialty> specialties = new HashSet<>();
        specialties.add(specialty1);
        specialties.add(specialty2);
        when(specialty1.getName()).thenReturn("Cardiology");
        when(specialty2.getName()).thenReturn("Dentistry");
        vet.setSpecialtiesInternal(specialties);
    }

    @Test
    public void testGetSpecialties() {
        List<Specialty> specialties = vet.getSpecialties();
        assertEquals(2, specialties.size());
        assertEquals("Cardiology", specialties.get(0).getName());
        assertEquals("Dentistry", specialties.get(1).getName());
    }

    @Test
    public void testGetSpecialties_Empty() {
        vet.setSpecialtiesInternal(new HashSet<>());
        List<Specialty> specialties = vet.getSpecialties();
        assertEquals(0, specialties.size());
    }
}
