package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.PetType;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class Pet_setType_7057616207_Test {

    @InjectMocks
    Pet pet;

    PetType dog;
    PetType cat;

    @BeforeEach
    void setup() {
        dog = new PetType();
        dog.setName("Dog");
        cat = new PetType();
        cat.setName("Cat");
    }

    @Test
    public void testSetType_Dog() {
        pet.setType(dog);
        assertThat(pet.getType().getName()).isEqualTo("Dog");
    }

    @Test
    public void testSetType_Cat() {
        pet.setType(cat);
        assertThat(pet.getType().getName()).isEqualTo("Cat");
    }

    @Test
    public void testSetType_Null() {
        pet.setType(null);
        assertThat(pet.getType()).isNull();
    }
}
