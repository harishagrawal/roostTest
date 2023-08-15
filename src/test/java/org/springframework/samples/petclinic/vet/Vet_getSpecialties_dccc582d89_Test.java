package org.springframework.samples.petclinic.vet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.samples.petclinic.model.Specialty;
import org.springframework.samples.petclinic.model.Vet;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Vet_getSpecialties_dccc582d89_Test {

    @Mock
    private Vet vet;

    private Specialty spec1;
    private Specialty spec2;

    @BeforeEach
    public void setup() {
        spec1 = new Specialty();
        spec1.setName("Cardiology");

        spec2 = new Specialty();
        spec2.setName("Dentistry");

        Set<Specialty> specialties = new HashSet<>();
        specialties.add(spec1);
        specialties.add(spec2);

        when(vet.getSpecialtiesInternal()).thenReturn(specialties);
    }

    @Test
    public void testGetSpecialtiesSuccess() {
        List<Specialty> expected = new ArrayList<>();
        expected.add(spec1);
        expected.add(spec2);
        PropertyComparator.sort(expected, new MutableSortDefinition("name", true, true));

        List<Specialty> actual = vet.getSpecialties();

        assertEquals(expected, actual);
    }

    @Test
    public void testGetSpecialtiesFailure() {
        List<Specialty> expected = new ArrayList<>();
        expected.add(spec2);
        expected.add(spec1);
        PropertyComparator.sort(expected, new MutableSortDefinition("name", true, true));

        List<Specialty> actual = vet.getSpecialties();

        // This test should fail because the specialties are not in the same order
        assertEquals(expected, actual);
    }
}
