package org.springframework.samples.petclinic.owner;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class OwnerController2_OwnerController2_01992a6daf_Test {

    @Mock
    private OwnerRepository clinicService;

    @InjectMocks
    private OwnerController2 ownerController2;

    @BeforeEach
    void setUp() {
        // ownerController2 is instantiated via @InjectMocks, so we don't need to do it here
    }

    @Test
    public void testOwnerController2_WithValidClinicService() {
        assertNotNull(ownerController2);
    }
}
