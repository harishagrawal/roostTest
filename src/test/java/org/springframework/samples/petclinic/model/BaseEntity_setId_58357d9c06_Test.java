package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BaseEntity_setId_58357d9c06_Test {

    BaseEntity baseEntity;

    @BeforeEach
    public void setup() {
        baseEntity = Mockito.mock(BaseEntity.class);
    }

    @Test
    public void testSetIdPositive() {
        Mockito.doAnswer(invocation -> {
            Integer id = invocation.getArgument(0);
            assertEquals(5, id);
            return null;
        }).when(baseEntity).setId(Mockito.anyInt());

        baseEntity.setId(5);
    }

    @Test
    public void testSetIdNegative() {
        Mockito.doAnswer(invocation -> {
            Integer id = invocation.getArgument(0);
            assertEquals(-5, id);
            return null;
        }).when(baseEntity).setId(Mockito.anyInt());

        baseEntity.setId(-5);
    }

    @Test
    public void testSetIdNull() {
        Mockito.doAnswer(invocation -> {
            Object id = invocation.getArgument(0);
            assertNull(id);
            return null;
        }).when(baseEntity).setId(null);

        baseEntity.setId(null);
    }
}
