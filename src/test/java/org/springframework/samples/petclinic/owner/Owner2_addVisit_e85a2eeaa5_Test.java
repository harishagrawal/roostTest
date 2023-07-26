package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.Visit;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Owner2_addVisit_e85a2eeaa5_Test {

    @InjectMocks
    private OwnerService ownerService;

    @Mock
    private PetRepository petRepository;

    @Mock
    private Pet pet;

    private Visit visit;

    @BeforeEach
    void setup() {
        visit = new Visit();
    }

    @Test
    public void testAddVisitSuccess() {
        when(petRepository.findById(any(Integer.class))).thenReturn(Optional.of(pet));
        ownerService.addVisit(1, visit);
        verify(petRepository, times(1)).findById(any(Integer.class));
        verify(pet, times(1)).addVisit(visit);
    }

    @Test
    public void testAddVisitWithNullPetId() {
        assertThrows(IllegalArgumentException.class, () -> {
            ownerService.addVisit(null, visit);
        });
    }

    @Test
    public void testAddVisitWithNullVisit() {
        assertThrows(IllegalArgumentException.class, () -> {
            ownerService.addVisit(1, null);
        });
    }

    @Test
    public void testAddVisitWithInvalidPetId() {
        when(petRepository.findById(any(Integer.class))).thenReturn(Optional.empty());
        assertThrows(IllegalArgumentException.class, () -> {
            ownerService.addVisit(1, visit);
        });
    }
}
