package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BaseEntity_setId_58357d9c06_Test {
    private BaseEntity baseEntity;

    @BeforeEach
    void setup() {
        baseEntity = new BaseEntity();
    }

    @Test
    public void testSetIdPositive() {
        Integer expectedId = 1;
        baseEntity.setId(expectedId);
        assertEquals(expectedId, baseEntity.getId());
    }

    @Test
    public void testSetIdNull() {
        baseEntity.setId(null);
        assertEquals(null, baseEntity.getId());
    }
}
