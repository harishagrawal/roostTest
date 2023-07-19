package org.springframework.samples.petclinic.vet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.samples.petclinic.model.Specialty;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Vet_getSpecialties_1b7e106756_Test {

    @InjectMocks
    Vet vet;

    @Mock
    Specialty specialty1;

    @Mock
    Specialty specialty2;

    @BeforeEach
    public void setUp() {
        Set<Specialty> specialties = new HashSet<>();
        specialties.add(specialty1);
        specialties.add(specialty2);
        when(specialty1.getName()).thenReturn("surgery");
        when(specialty2.getName()).thenReturn("dentistry");
        vet.setSpecialtiesInternal(specialties);
    }

    @Test
    public void testGetSpecialties() {
        List<Specialty> sortedSpecs = new ArrayList<>(vet.getSpecialtiesInternal());
        PropertyComparator.sort(sortedSpecs, new MutableSortDefinition("name", true, true));
        List<Specialty> expected = Collections.unmodifiableList(sortedSpecs);

        List<Specialty> actual = vet.getSpecialties();

        assertEquals(expected, actual);
    }

    @Test
    public void testGetSpecialtiesEmpty() {
        Vet emptyVet = new Vet();
        List<Specialty> expected = Collections.emptyList();

        List<Specialty> actual = emptyVet.getSpecialties();

        assertEquals(expected, actual);
    }
}
