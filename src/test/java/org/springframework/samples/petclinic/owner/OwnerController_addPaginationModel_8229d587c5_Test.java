package org.springframework.samples.petclinic.owner;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.springframework.data.domain.Page;
import org.springframework.samples.petclinic.owner.Owner;

public class OwnerController_addPaginationModel_8229d587c5_Test {

	private Model model;
	private Page<Owner> paginated;

	@BeforeEach
	public void setup() {
		model = mock(Model.class);
		paginated = mock(Page.class);
	}

	@Test
	public void testAddPaginationModelSuccess() {
		Owner owner1 = new Owner();
		Owner owner2 = new Owner();
		List<Owner> listOwners = Arrays.asList(owner1, owner2);

		when(paginated.getContent()).thenReturn(listOwners);
		when(paginated.getTotalPages()).thenReturn(2);
		when(paginated.getTotalElements()).thenReturn(2L);

		String view = addPaginationModel(1, model, paginated);

		verify(model).addAttribute("listOwners", listOwners);
		verify(model).addAttribute("currentPage", 1);
		verify(model).addAttribute("totalPages", 2);
		verify(model).addAttribute("totalItems", 2L);

		assertEquals("owners/ownersList", view);
	}

	@Test
	public void testAddPaginationModelNoOwners() {
		List<Owner> listOwners = Arrays.asList();

		when(paginated.getContent()).thenReturn(listOwners);
		when(paginated.getTotalPages()).thenReturn(0);
		when(paginated.getTotalElements()).thenReturn(0L);

		String view = addPaginationModel(1, model, paginated);

		verify(model).addAttribute("listOwners", listOwners);
		verify(model).addAttribute("currentPage", 1);
		verify(model).addAttribute("totalPages", 0);
		verify(model).addAttribute("totalItems", 0L);

		assertEquals("owners/ownersList", view);
	}

	private String addPaginationModel(int page, Model model, Page<Owner> paginated) {
		List<Owner> listOwners = paginated.getContent();
		model.addAttribute("listOwners", listOwners);
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", paginated.getTotalPages());
		model.addAttribute("totalItems", paginated.getTotalElements());
		return "owners/ownersList";
	}
}
