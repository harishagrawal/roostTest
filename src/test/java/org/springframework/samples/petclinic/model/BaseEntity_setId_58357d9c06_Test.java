package org.springframework.samples.petclinic.model;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseEntity_setId_58357d9c06_Test {

    private BaseEntity baseEntity;

    @Before
    public void setUp() {
        baseEntity = new BaseEntity();
    }

    @Test
    public void testSetId_positive() {
        Integer id = 123;
        baseEntity.setId(id);
        assertEquals(id, baseEntity.getId());
    }

    @Test
    public void testSetId_null() {
        baseEntity.setId(null);
        assertEquals(null, baseEntity.getId());
    }
}
