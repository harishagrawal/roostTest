package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class VisitController_VisitController_d892c06aa4_Test {

    @InjectMocks
    VisitController visitController;

    @Mock
    OwnerRepository ownerRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testVisitController() {
        when(ownerRepository.findById(1)).thenReturn(new Owner());
        assertNotNull(visitController);
    }

    @Test
    public void testVisitControllerNullOwner() {
        when(ownerRepository.findById(1)).thenReturn(null);
        assertNotNull(visitController);
    }
}
