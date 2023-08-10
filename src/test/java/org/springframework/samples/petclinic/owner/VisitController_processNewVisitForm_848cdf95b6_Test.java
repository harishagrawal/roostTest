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
    private VisitController visitController;

    @Mock
    private Owner owner;

    @Mock
    private BindingResult result;

    @Mock
    private Visit visit;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testProcessNewVisitForm_Success() {
        when(result.hasErrors()).thenReturn(false);
        doNothing().when(owner).addVisit(visit);
        String actual = visitController.processNewVisitForm(owner, 1, visit, result);
        assertEquals("redirect:/owners/{ownerId}", actual);
        verify(owner, times(1)).addVisit(visit);
    }

    @Test
    public void testProcessNewVisitForm_Failure() {
        when(result.hasErrors()).thenReturn(true);
        String actual = visitController.processNewVisitForm(owner, 1, visit, result);
        assertEquals("pets/createOrUpdateVisitForm", actual);
        verify(owner, times(0)).addVisit(visit);
    }
}
