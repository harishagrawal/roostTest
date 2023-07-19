package org.springframework.samples.petclinic.vet;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Specialty;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class Vet_getSpecialtiesInternal_b3441a28b5_Test {

    @InjectMocks
    private Vet vet;

    @BeforeEach
    public void setUp() {
        vet = new Vet();
    }

    @Test
    public void testGetSpecialtiesInternal_WhenSpecialtiesIsNull() {
        Set<Specialty> specialties = vet.getSpecialtiesInternal();
        assertNotNull(specialties);
        assertEquals(0, specialties.size());
    }

    @Test
    public void testGetSpecialtiesInternal_WhenSpecialtiesIsNotNull() {
        Specialty specialty = new Specialty();
        specialty.setName("surgery");
        vet.addSpecialty(specialty);

        Set<Specialty> specialties = vet.getSpecialtiesInternal();
        assertNotNull(specialties);
        assertEquals(1, specialties.size());
        assertEquals("surgery", specialties.iterator().next().getName());
    }
}
