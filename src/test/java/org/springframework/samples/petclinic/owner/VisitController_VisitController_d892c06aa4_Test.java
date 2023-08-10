package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class VisitController_VisitController_d892c06aa4_Test {

    @Mock
    private OwnerRepository owners;

    @InjectMocks
    private VisitController visitController;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testVisitController() {
        OwnerRepository ownerRepositoryMock = mock(OwnerRepository.class);
        VisitController visitController = new VisitController();
        assertEquals(ownerRepositoryMock, visitController.getOwners());
    }

    @Test
    public void testVisitController_NullOwnerRepository() {
        try {
            new VisitController();
        } catch (IllegalArgumentException e) {
            assertEquals("OwnerRepository must not be null", e.getMessage());
        }
    }
}
