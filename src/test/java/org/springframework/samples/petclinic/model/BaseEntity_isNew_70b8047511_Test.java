package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BaseEntity_isNew_70b8047511_Test {

    private BaseEntity baseEntity;

    @BeforeEach
    public void setup() {
        this.baseEntity = new BaseEntity();
    }

    @Test
    public void testIsNew_WhenIdIsNull() {
        this.baseEntity.setId(null);
        Assertions.assertTrue(this.baseEntity.isNew());
    }

    @Test
    public void testIsNew_WhenIdIsNotNull() {
        this.baseEntity.setId(1);
        Assertions.assertFalse(this.baseEntity.isNew());
    }
}
