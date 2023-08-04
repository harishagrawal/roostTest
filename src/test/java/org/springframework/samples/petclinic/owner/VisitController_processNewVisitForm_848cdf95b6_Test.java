package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BindingResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class VisitController_processNewVisitForm_848cdf95b6_Test {

    private Owner owner;
    private Visit visit;
    private BindingResult result;
    private OwnerRepository owners;
    private int petId = 1;

    @BeforeEach
    public void setup() {
        owner = Mockito.mock(Owner.class);
        visit = Mockito.mock(Visit.class);
        result = Mockito.mock(BindingResult.class);
        owners = Mockito.mock(OwnerRepository.class);
    }

    @Test
    public void testProcessNewVisitForm_success() {
        when(result.hasErrors()).thenReturn(false);
        String view = processNewVisitForm(owner, petId, visit, result);
        assertEquals("redirect:/owners/{ownerId}", view);
    }

    @Test
    public void testProcessNewVisitForm_failure() {
        when(result.hasErrors()).thenReturn(true);
        String view = processNewVisitForm(owner, petId, visit, result);
        assertEquals("pets/createOrUpdateVisitForm", view);
    }

    public String processNewVisitForm(Owner owner, int petId, Visit visit, BindingResult result) {
        if (result.hasErrors()) {
            return "pets/createOrUpdateVisitForm";
        }

        owner.addVisit(petId, visit);
        this.owners.save(owner);
        return "redirect:/owners/{ownerId}";
    }
}
