package com.example.first;

import com.example.first.repository.InteractionsRepository;
import com.example.first.utility.Courses;
import com.example.first.utility.Interactions;
import com.example.first.utility.Rating;
import com.example.first.utility.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FirstApplicationTests {

	@Mock
	private InteractionsRepository repo; // Mock the repository

	@Test
	void testGetInteractions_NotFound() {
		// Given: Mock the repository to return an empty Optional
		when(repo.findInteractionsByUserEmailAddress("test")).thenReturn(Optional.empty());

		// When: Call the repository method
		Optional<Interactions> result = repo.findInteractionsByUserEmailAddress("test");

		// Then: Verify the result and repository interaction
		assertTrue(result.isEmpty(), "Expected an empty Optional when no interactions are found");
		verify(repo, times(1)).findInteractionsByUserEmailAddress("test");
	}

	@Test
	void testGetInteractions_Found() {
		// Given: Create a test Interactions object
		Interactions interaction = new Interactions();
		User u = new User();
		u.setEmailAddress("test");
		Courses c = new Courses();
		Rating r = new Rating();
		r.setValue(20.00);
		c.setRatings(Collections.singletonList(r));
		c.setName("test");
		interaction.setUser(u);
		interaction.setCourses(c);
		// Mock the repository to return a non-empty Optional
		when(repo.findInteractionsByUserEmailAddress("test")).thenReturn(Optional.of(interaction));

		// When: Call the repository method
		Optional<Interactions> result = repo.findInteractionsByUserEmailAddress("test");

		// Then: Verify the result and repository interaction
		assertTrue(result.isPresent(), "Expected a non-empty Optional when interactions are found");
		System.out.println(result.toString());
		assertEquals("test", result.get().getUser().getEmailAddress());
		verify(repo, times(1)).findInteractionsByUserEmailAddress("test");
	}
}