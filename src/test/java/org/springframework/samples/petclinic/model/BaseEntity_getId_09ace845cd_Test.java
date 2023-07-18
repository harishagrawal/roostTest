package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BaseEntity_getId_09ace845cd_Test {
    private BaseEntity baseEntity;

    @BeforeEach
    public void setup() {
        baseEntity = Mockito.mock(BaseEntity.class);
    }

    @Test
    public void testGetIdSuccess() {
        Mockito.when(baseEntity.getId()).thenReturn(1);
        Integer id = baseEntity.getId();
        assertEquals(1, id, "The returned id should be 1");
    }

    @Test
    public void testGetIdNull() {
        Mockito.when(baseEntity.getId()).thenReturn(null);
        Integer id = baseEntity.getId();
        assertNull(id, "The returned id should be null");
    }
}
