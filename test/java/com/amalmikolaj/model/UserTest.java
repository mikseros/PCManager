package com.amalmikolaj.model;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertAll;

class UserTest {
	
	User user;
	
	@BeforeAll
	void setUp() {
		user = new User(7, "Johny", "Bravo", "1989-01-01", "user");
	}
	
	@Test
	void testUser() {
		assertAll("user",
				() -> assertEquals(7, user.getId()),
	            () -> assertEquals("Johny", user.getName()),
	            () -> assertEquals("Bravo", user.getSurname()),
	            () -> assertEquals("1989-01-01", user.getDateOfBirth()),
	            () -> assertEquals("user", user.getPost())
	        );
	}

	@Test
	@DisplayName("Show all workstations")
	void testShowMachines() throws Exception {
		
	}

	@Test
	void testShowMachine() {
		fail("Not yet implemented");
	}

	@Test
	void testAddMachine() {
		fail("Not yet implemented");
	}

	@Test
	void testEditMyProfile() {
		fail("Not yet implemented");
	}

}
