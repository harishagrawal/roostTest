package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.any;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VisitController_VisitController_d892c06aa4_Test {

    @InjectMocks
    VisitController visitController;

    @Mock
    OwnerRepository owners;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testVisitControllerConstructor() {
        // TODO: Replace 'newOwnerRepository' with actual OwnerRepository object
        OwnerRepository newOwnerRepository = null; // replace null with actual object
        VisitController visitController = new VisitController();
        assertEquals(newOwnerRepository, visitController.getOwners());
    }

    @Test
    public void testVisitControllerConstructor_NullOwnerRepository() {
        VisitController visitController = new VisitController();
        assertEquals(null, visitController.getOwners());
    }
}
