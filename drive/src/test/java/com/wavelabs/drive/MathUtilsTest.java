package com.wavelabs.drive;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assumptions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

// In this case Instance of MathUtils is created only once if you use PER_CLASS in TestInstance annotation
// If you use this TestInstance annotation BeforeAll and AfterAll annotated methods need not to be static 
// If you use PER_METHOD in TestInstance annotation is same as earlier it creates new instance per method
// And BeforeAll and AfterAll annotated methods should to be static
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathUtilsTest {

	MathUtils math;

//	Initialize before anything in this class runs
//	But only restriction is method should static and don't depend on object creation
//	because non-static methods can't runs without object creation of test class by junit
	@BeforeAll
	void beforeAllInit() {
		System.out.println("This needs to run before all");
	}

//	Teardown after all test methods are done
//	But only restriction is method should static and don't depend on object creation
//	because non-static methods can't runs without object creation of test class by junit
	@AfterAll
	void afterAllCleanUp() {
		System.out.println("This needs to run after all");
	}

//	Initialize before each method and destory's after completion of each test method
	@BeforeEach
	void init() {
		math = new MathUtils();
		System.out.println("MathUtils class is Instanciated");
	}

//	Teardown after each test method
	@AfterEach
	void cleanUp() {
		System.out.println("Cleaning Up...");
	}

//	Test annotation makes method as test method(testcases) of your original class
	@Test
	@DisplayName("Testing add method")
	void testAdd() {
		int expected = 3;
		int actual = math.add(1, 2);
		assertEquals(expected, actual, "The add method should add two numbers");
	}

//	we can have nested class by using nested annotation
	@Nested
	@DisplayName("Add method")
	class AddTest {

		@Test
		@DisplayName("adding two positive numbers")
		void testAddPositive() {
			assertEquals(2, math.add(1, 1), "should return the right sum");
		}

		@Test
		@DisplayName("adding two positive numbers")
		void testAddNegative() {
			assertEquals(-2, math.add(-1, -1), "should return the right sum");
		}
	}

	@Test
	@DisplayName("Testing multiply method")
	void testMultiply() {
		assertAll(() -> assertEquals(4, math.multiply(2, 2)), () -> assertEquals(0, math.multiply(2, 0)),
				() -> assertEquals(-2, math.multiply(2, -1)));

	}

//	assumptions are like if your value is true then method will run else it skips the method
	@Test
	@DisplayName("Testing divide method")
	void testDivide() {
		boolean value = false;
		assumeTrue(value);
		assertThrows(ArithmeticException.class, () -> math.divide(1, 0), "Divide by zero should throw");
	}

//	DisplayName annotation gives understandable name to method 
//	after running method will be visible at junit console
	@Test
	@DisplayName("Testing circle area method")
	void testComputeCircleArea() {
		assertEquals(314.1592653589793, math.computeCircleArea(10), "should return circle area");
	}

//	If any test method has assertions like fail in it 
//	to disable it we use Disabled annotation which skips this test and continue other test method to run
	@Test
	@Disabled
	@DisplayName("should not run")
	void testDisabled() {
		fail("This test should be disabled");
	}
}
