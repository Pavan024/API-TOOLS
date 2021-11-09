package com.wavelabs.drive;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class AppTest {
	App app;

	@BeforeEach
	void init() {
		app = new App();
	}

	@Test
	void testCalculator() {

		int expected = 3;
		int actual = app.calculator(1, 2, '+');
		assertEquals(expected, actual, "This is addition of two numbers");
	}

	@Test
	void testCircleArea() {

		double result = app.circleArea(10);
		assertEquals(314.1592653589793, result, "Area of circle");
		assertTrue(result == 314.1592653589793, "Area of Cicle");
	}

//	While using @After All annotation method must be static or 
//	test class should be annotated with @TestInstance(Lifecycle.PER_CLASS)
	@AfterAll
	void close() {
		System.out.println("All test cases executed");
	}

	@AfterEach
	void message() {
		System.out.println("Test case executed");
	}
}