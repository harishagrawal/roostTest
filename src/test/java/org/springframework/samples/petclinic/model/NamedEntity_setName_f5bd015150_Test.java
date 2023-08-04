package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NamedEntity_setName_f5bd015150_Test {

  private NamedEntity namedEntity;

  @BeforeEach
  public void setUp() {
    namedEntity = new NamedEntity();
  }

  @Test
  public void testSetName_ValidName() {
    String validName = "Test Name";
    namedEntity.setName(validName);
    Assertions.assertEquals(validName, namedEntity.getName(), "Expected name to be set correctly.");
  }

  @Test
  public void testSetName_NullName() {
    String nullName = null;
    namedEntity.setName(nullName);
    Assertions.assertNull(namedEntity.getName(), "Expected name to be null.");
  }
}
