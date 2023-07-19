package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BindingResult;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class VisitController_processNewVisitForm_848cdf95b6_Test {

    @Mock
    private Owner owner;

    @Mock
    private BindingResult result;

    @Mock
    private Visit visit;

    @InjectMocks
    private VisitController visitController;

    @BeforeEach
    public void setup() {
        when(owner.addVisit(anyInt(), any(Visit.class))).thenReturn(visit);
    }

    @Test
    public void testProcessNewVisitForm_Success() {
        when(result.hasErrors()).thenReturn(false);
        String view = visitController.processNewVisitForm(owner, 1, visit, result, null);
        verify(owner, times(1)).addVisit(anyInt(), any(Visit.class));
        assert(view.equals("redirect:/owners/{ownerId}"));
    }

    @Test
    public void testProcessNewVisitForm_Failure() {
        when(result.hasErrors()).thenReturn(true);
        String view = visitController.processNewVisitForm(owner, 1, visit, result, null);
        verify(owner, times(0)).addVisit(anyInt(), any(Visit.class));
        assert(view.equals("pets/createOrUpdateVisitForm"));
    }
}
