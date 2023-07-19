package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class OwnerController2_OwnerController2_cb93b59b02_Test {

    @Mock
    OwnerRepository clinicService;

    @InjectMocks
    OwnerController2 ownerController2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testOwnerController2Success() {
        OwnerRepository clinicService = mock(OwnerRepository.class);
        OwnerController2 ownerController2 = new OwnerController2();
        assertNotNull(ownerController2);
    }

    @Test
    void testOwnerController2Failure() {
        assertThrows(NullPointerException.class, () -> {
            new OwnerController2();
        });
    }
}
