package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.validation.BindingResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class VisitController_processNewVisitForm_848cdf95b6_Test {

    @InjectMocks
    private VisitController visitController = new VisitController();

    @Mock
    private Owner owner = new Owner();

    @Mock
    private BindingResult result = mock(BindingResult.class);

    @Mock
    private Visit visit = new Visit();

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testProcessNewVisitForm_Success() {
        int petId = 1; 
        when(result.hasErrors()).thenReturn(false);
        when(owner.addVisit(anyInt(), any(Visit.class))).thenReturn(visit);
        String view = visitController.processNewVisitForm(owner, petId, visit, result);
        verify(owner, times(1)).addVisit(petId, visit);
        assertEquals("redirect:/owners/{ownerId}", view);
    }

    @Test
    public void testProcessNewVisitForm_Failure() {
        int petId = 1; 
        when(result.hasErrors()).thenReturn(true);
        String view = visitController.processNewVisitForm(owner, petId, visit, result);
        assertEquals("pets/createOrUpdateVisitForm", view);
    }
}
