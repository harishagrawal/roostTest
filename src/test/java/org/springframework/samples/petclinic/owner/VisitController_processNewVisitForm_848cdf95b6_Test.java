package org.springframework.samples.petclinic.owner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BindingResult;

public class VisitController_processNewVisitForm_848cdf95b6_Test {

    @Mock
    private OwnerService owners;

    @Mock
    private Owner owner;

    @Mock
    private BindingResult result;

    @Mock
    private Visit visit;

    @InjectMocks
    private VisitController visitController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(visitController).build();
    }

    @Test
    public void testProcessNewVisitForm_success() throws Exception {
        when(result.hasErrors()).thenReturn(false);
        mockMvc.perform(post("/owners/{ownerId}/pets/{petId}/visits/new", 1, 1)
                .flashAttr("owner", owner)
                .flashAttr("visit", visit))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/{ownerId}"));

        verify(owner).addVisit(eq(1), any(Visit.class));
        verify(owners).save(any(Owner.class));
    }

    @Test
    public void testProcessNewVisitForm_failure() throws Exception {
        when(result.hasErrors()).thenReturn(true);
        mockMvc.perform(post("/owners/{ownerId}/pets/{petId}/visits/new", 1, 1)
                .flashAttr("owner", owner)
                .flashAttr("visit", visit))
                .andExpect(status().isOk())
                .andExpect(view().name("pets/createOrUpdateVisitForm"));

        verify(owner, Mockito.never()).addVisit(eq(1), any(Visit.class));
        verify(owners, Mockito.never()).save(any(Owner.class));
    }
}
