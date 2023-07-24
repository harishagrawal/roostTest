package org.springframework.samples.petclinic.vet;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Vet_getSpecialties_1b7e106756_Test {

    private Vet vet;
    private Specialty specialty1;
    private Specialty specialty2;

    @Before
    public void setUp() {
        vet = new Vet();
        specialty1 = mock(Specialty.class);
        specialty2 = mock(Specialty.class);
    }

    @Test
    public void testGetSpecialties() {
        List<Specialty> specialties = new ArrayList<>();
        specialties.add(specialty1);
        specialties.add(specialty2);
        when(specialty1.getName()).thenReturn("Cardiology");
        when(specialty2.getName()).thenReturn("Dentistry");
        vet.setSpecialtiesInternal(specialties);

        List<Specialty> sortedSpecs = vet.getSpecialties();
        PropertyComparator.sort(sortedSpecs, new MutableSortDefinition("name", true, true));
        assertEquals(2, sortedSpecs.size());
        assertEquals("Cardiology", sortedSpecs.get(0).getName());
        assertEquals("Dentistry", sortedSpecs.get(1).getName());
    }

    @Test
    public void testGetSpecialtiesEmpty() {
        List<Specialty> specialties = new ArrayList<>();
        vet.setSpecialtiesInternal(specialties);

        List<Specialty> sortedSpecs = vet.getSpecialties();
        assertEquals(0, sortedSpecs.size());
    }
}
