package org.springframework.samples.petclinic.vet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.samples.petclinic.model.Person;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlElement;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class Vet_getSpecialties_1b7e106756_Test {
    @Mock
    private Vet vet;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetSpecialties_Success() {
        Specialty specialty1 = new Specialty();
        specialty1.setName("surgery");
        Specialty specialty2 = new Specialty();
        specialty2.setName("dentistry");

        Set<Specialty> specialties = new HashSet<>();
        specialties.add(specialty1);
        specialties.add(specialty2);

        when(vet.getSpecialtiesInternal()).thenReturn(specialties);

        List<Specialty> expected = new ArrayList<>();
        expected.add(specialty2);
        expected.add(specialty1);

        List<Specialty> actual = vet.getSpecialties();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetSpecialties_Empty() {
        Set<Specialty> specialties = new HashSet<>();

        when(vet.getSpecialtiesInternal()).thenReturn(specialties);

        List<Specialty> expected = new ArrayList<>();
        List<Specialty> actual = vet.getSpecialties();
        assertEquals(expected, actual);
    }
}
