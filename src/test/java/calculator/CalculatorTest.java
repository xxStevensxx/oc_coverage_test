package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorTest {

	private static Instant startedAt;
	private static Calculator calculatorUndertest;

	@BeforeEach
	public void initCalculator() {
		System.out.print(" Appel avant chaque test");
		calculatorUndertest = new Calculator();

	}

	@AfterEach
	public void cleanCalculator() {
		calculatorUndertest = null;
//	 System.out.print( " RESULTS OF CalculatorUnderTest =  " + calculatorUndertest);
	}

	@Test
	void testAddTwoPositiveNumbers() {
		// ARRANGE
		int a = 2;
		int b = 3;

		// ACT
		int somme = calculatorUndertest.add(a, b);

		// ASSERT
//		assertEquals(5, somme);
		assertThat(somme).isEqualTo(5);

	}

	@Test
	void multiply_shouldReturnTheProduct_ofTwo_integer() {
		// ARRANGE
		int a = 42;
		int b = 13;

		// ACT
		int produit = calculatorUndertest.multiply(a, b);

		// ASSERT
		assertEquals(546, produit);
		System.out.println(calculatorUndertest);
	}

	@BeforeAll
	static public void initStartDurationTime() {
		System.out.print(" Start duration ");
		startedAt = Instant.now();
	}

	@AfterAll
	static public void showTestDuration() {
		Instant endedAt = Instant.now();
		Long duration = Duration.between(startedAt, endedAt).toMillis();
		System.out.print(MessageFormat.format(" Durée des tests : {0} ms ", duration));
	}

	@ParameterizedTest(name = "{0} X 0 doit etre égale à zéro")
	@ValueSource(ints = { 1, 2, 42, 1011, 5089 })
	public void multiplyBy_zeroShouldBe_returnZero(int arg) {
		// ARRANGE -- Tout est pret !

		// ACT
		int actualResult = calculatorUndertest.multiply(arg, 0);

		// ASSERT
		assertEquals(0, actualResult);
	}

	@ParameterizedTest(name = "{0} + {1} should be equal to {2}")
	@CsvSource({ "1,1,2", "2,3,5", "42,57,99" })
	public void add_shouldReturnThe_sum_ofMultipleIntegers(int arg1, int arg2, int expectedResult) {
		// ARRANGE -- Tout est pret !

		// ACT
		int result = calculatorUndertest.add(arg1, arg2);

		// ASSERT
		assertEquals(expectedResult, result);
	}

	@Timeout(1)
	@Test
	public void longCalcul_shouldComputeInLessThan1Sec() {
		// ARRANGE

		// ACT
		calculatorUndertest.longCalculation();

	}
	
////	@Test
//	public void listDigit_shouldReturnTheListOf_digit() {
//		// GIVEN
//		int number = 9587;
//
//		// WHEN
//		Set<Integer> actualDigit = calculatorUndertest.digitsSet(number);
//
//		// THEN
//		Set<Integer> expectedDigit = Stream.of(5, 7, 8, 9).collect(Collectors.toSet());
////		assertEquals(expectedDigit, actualDigit); 
//		assertThat(actualDigit).containsExactlyInAnyOrder(9, 5, 8, 7);
//	}
//	
	@Test
	public void divise_shouldReturnResult() {
		//ARRANGE
		double a = 36;
		double b = 2;
		
	
		
		//ACT
		double quotient = calculatorUndertest.divise(a, b);
		
		
		//ASSERT
		assertThat(quotient).isEqualTo(a / b);
		
		
	}

}
