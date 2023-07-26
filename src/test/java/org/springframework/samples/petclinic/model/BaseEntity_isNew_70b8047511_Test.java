package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;

public class BaseEntity_isNew_70b8047511_Test {

    @Mock
    private BaseEntity baseEntity;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testIsNew_whenIdIsNull() {
        Mockito.when(baseEntity.getId()).thenReturn(null);
        assertTrue(baseEntity.isNew(), "Expected true when id is null");
    }

    @Test
    public void testIsNew_whenIdIsNotNull() {
        Mockito.when(baseEntity.getId()).thenReturn(1);
        assertFalse(baseEntity.isNew(), "Expected false when id is not null");
    }
}
