package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class OwnerController_OwnerController_35fab86ffa_Test {

    @InjectMocks
    private OwnerController ownerController;

    @Mock
    private OwnerRepository ownerRepository;

    @Test
    public void testOwnerControllerNotNull() {
        assertNotNull(ownerController);
    }

    @Test
    public void testOwnerRepositoryNotNull() {
        assertNotNull(ownerRepository);
    }
}
