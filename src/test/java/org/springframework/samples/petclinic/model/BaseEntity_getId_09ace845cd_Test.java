package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BaseEntity_getId_09ace845cd_Test {

    private BaseEntity baseEntity;

    @BeforeEach
    public void setup() {
        baseEntity = new BaseEntity();
    }

    @Test
    public void testGetIdWithNullId() {
        baseEntity.setId(null);
        Integer id = baseEntity.getId();
        assertEquals(null, id, "The id should be null");
    }

    @Test
    public void testGetIdWithNonNullId() {
        Integer expectedId = 123;
        baseEntity.setId(expectedId);
        Integer actualId = baseEntity.getId();
        assertEquals(expectedId, actualId, "The id should be " + expectedId);
    }
}
