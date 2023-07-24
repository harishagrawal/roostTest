package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class OwnerController2_OwnerController2_cb93b59b02_Test {

    @Mock
    private OwnerRepository clinicService;

    @InjectMocks
    private OwnerController2 ownerController2;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testOwnerController2_Success() {
        OwnerRepository clinicServiceMock = mock(OwnerRepository.class);
        when(clinicServiceMock.save(any())).thenReturn(null);
        assertNotNull(ownerController2);
    }

    @Test
    public void testOwnerController2_Failure() {
        try {
            OwnerController2 ownerController2 = new OwnerController2();
            fail("Should have thrown an exception");
        } catch (NullPointerException e) {
            assertEquals("clinicService cannot be null", e.getMessage());
        }
    }
}
