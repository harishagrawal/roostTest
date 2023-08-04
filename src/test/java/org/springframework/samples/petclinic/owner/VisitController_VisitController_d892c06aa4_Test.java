package org.springframework.samples.petclinic.owner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class VisitController_VisitController_d892c06aa4_Test {

    @InjectMocks
    VisitController visitController;

    @Mock
    OwnerRepository ownerRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testVisitControllerConstructorWithValidOwnerRepository() {
        verifyNoMoreInteractions(ownerRepository);
    }

    @Test(expected = NullPointerException.class)
    public void testVisitControllerConstructorWithNullOwnerRepository() {
        when(ownerRepository.findById(anyInt())).thenReturn(null);
        visitController.loadOwner(anyInt(), anyMap());
    }
}
