package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class Owner2_getAddress_4a6790754a_Test {

    @Autowired
    private Owner owner;

    @MockBean
    private OwnerService ownerService;

    @Test
    public void testGetAddressSuccess() {
        String expectedAddress = "123 Main St";
        owner.setAddress(expectedAddress);
        Assertions.assertEquals(expectedAddress, owner.getAddress(), "Owner's address should match the expected address.");
    }

    @Test
    public void testGetAddressFailure() {
        String expectedAddress = "123 Main St";
        owner.setAddress("456 Elm St");
        Assertions.assertNotEquals(expectedAddress, owner.getAddress(), "Owner's address should not match the expected address.");
    }
}
