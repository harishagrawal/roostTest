package org.springframework.samples.petclinic.owner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public class OwnerController_processUpdateOwnerForm_f37e6381ef_Test {

    @Mock
    private OwnerRepository owners;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        OwnerController controller = new OwnerController();
        this.mockMvc = standaloneSetup(controller).build();
    }

    @Test
    public void testProcessUpdateOwnerFormSuccess() throws Exception {
        Owner owner = new Owner();
        owner.setId(1);
        owner.setFirstName("John");
        owner.setLastName("Doe");

        mockMvc.perform(post("/owners/{ownerId}", 1)
                .param("firstName", "John")
                .param("lastName", "Doe"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/{ownerId}"));

        verify(owners).save(owner);
    }

    @Test
    public void testProcessUpdateOwnerFormHasErrors() throws Exception {
        BindingResult result = Mockito.mock(BindingResult.class);
        when(result.hasErrors()).thenReturn(true);
        when(result.getFieldError()).thenReturn(new FieldError("owner", "name", "Name cannot be empty"));

        mockMvc.perform(post("/owners/{ownerId}", 1)
                .param("firstName", "")
                .param("lastName", "Doe"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/createOrUpdateOwnerForm"));

        verify(result).hasErrors();
    }
}
