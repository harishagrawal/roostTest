package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseEntity_getId_09ace845cd_Test {

    @InjectMocks
    private BaseEntity baseEntity;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetIdSuccess() {
        Integer expectedId = 1;
        baseEntity.setId(expectedId);
        Integer actualId = baseEntity.getId();
        assertEquals(expectedId, actualId, "Returned id should match the set id");
    }

    @Test
    public void testGetIdWhenIdIsNull() {
        baseEntity.setId(null);
        Integer actualId = baseEntity.getId();
        assertEquals(null, actualId, "Returned id should be null when id is not set");
    }
}
