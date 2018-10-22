package com.stringaccumulator.assignment.service;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.stringaccumulator.assignment.StringCalculator;

public class SimpleStringCalculatorTest {
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	StringCalculator stringCalculator = null;
	
	/** 
	 * Initialize the required objects before the tests  
	 */
	@Before
	public void init() {
		stringCalculator = new SimpleStringCalculator();		
	}
	
	/** 
	 * Test for null  
	 */
	@Test(expected = NullPointerException.class)
	public void testAddNull() {	
		stringCalculator.add(null);		
	}
	
	/** 
	 * Test for empty string 
	 */
	@Test
	public void testAddEmptyString() {			
		String numbers="";
		assertEquals("Sum should be 0", 0, stringCalculator.add(numbers));		
		numbers = null;
	}
	
	/** 
	 * Test for non-numerical values string 
	 */	
	@Test(expected = NumberFormatException.class)
	public void testAddNonNumericalString() {		
		stringCalculator.add("a");
	}
	
	/** 
	 * Test for single number
	 */
	@Test
	public void testAddOneNumber() {	
		String numbers="1";
		assertEquals("Sum should be 1", 1, stringCalculator.add(numbers));		
		numbers = null;
	}
	
	/** 
	 * Test for two numbers with comma delimiter
	 */
	@Test
	public void testAddTwoNumbersCommaDelimiter() {	
		String numbers="1,2";
		assertEquals("Sum should be 3", 3, stringCalculator.add(numbers));	
		numbers = null;
	}
	
	/** 
	 * Test for multiple numbers with comma delimiter
	 */
	@Test
	public void testAddNumbersCommaDelimiter() {		
		String numbers = "1,2,3";
		assertEquals("Sum should be 6", 6, stringCalculator.add(numbers));		
		numbers = null;
	}
	
	/** 
	 * Test for single negative number in the input with comma delimiter
	 */
	@Test
	public void testAddNegativeNumbersCommaDelimiterThrowExceptionCheckErrorMessage() {	
		exceptionRule.expect(IllegalArgumentException.class);
		exceptionRule.expectMessage("negatives not allowed : [-2]");
		String numbers = "1,-2,3";
		stringCalculator.add(numbers);		
	}
	
	/** 
	 * Test for multiple negative number in the input with comma delimiter
	 */
	@Test
	public void testAddMultipleNegativeNumbersCommaDelimiterThrowExceptionCheckErrorMessage() {	
		exceptionRule.expect(IllegalArgumentException.class);
		exceptionRule.expectMessage("negatives not allowed : [-2, -3]");
		String numbers = "1,-2,-3";
		stringCalculator.add(numbers);		
	}
	
	/** 
	 * Test for upper limit (1000) in the input with comma delimiter
	 */	
	@Test
	public void testAddNumbersWithThousandCommaDelimiter() {		
		String numbers = "2,1000";
		assertEquals("Sum should be 1002", 1002, stringCalculator.add(numbers));		
		numbers = null;
	}
	
	/** 
	 * Test for above upper limit (1000) in the input with comma delimiter
	 */		
	@Test
	public void testAddNumbersWithGreaterThanThousandCommaDelimiter() {		
		String numbers = "2,1001";
		assertEquals("Sum should be 2", 2, stringCalculator.add(numbers));		
		numbers = null;
	}
		
	/** 
	 * Test for two numbers with newline delimiter
	 */	
	@Test
	public void testAddTwoNumbersNewLineDelimiter() {	
		String numbers="1\n2";
		assertEquals("Sum should be 3", 3, stringCalculator.add(numbers));		
		numbers = null;
	}
	
	/** 
	 * Test for multiple numbers with newline delimiter
	 */	
	@Test
	public void testAddNumbersNewLineDelimiter() {	
		String numbers="1\n2\n3";
		assertEquals("Sum should be 6", 6, stringCalculator.add(numbers));		
		numbers = null;
	}
	
	/** 
	 * Test for single negative number in the input with newline delimiter
	 */
	@Test
	public void testAddNegativeNumbersNewLineDelimiterThrowExceptionCheckErrorMessage() {	
		exceptionRule.expect(IllegalArgumentException.class);
		exceptionRule.expectMessage("negatives not allowed : [-2]");
		String numbers = "1\n-2\n3";
		stringCalculator.add(numbers);		
	}
	
	/** 
	 * Test for multiple negative number in the input with newline delimiter
	 */
	@Test
	public void testAddMultipleNegativeNumbersNewLineDelimiterThrowExceptionCheckErrorMessage() {	
		exceptionRule.expect(IllegalArgumentException.class);
		exceptionRule.expectMessage("negatives not allowed : [-2, -3]");
		String numbers = "1\n-2\n-3";
		stringCalculator.add(numbers);		
	}
	
	/** 
	 * Test for upper limit (1000) in the input with newline delimiter
	 */	
	@Test
	public void testAddNumbersWithThousandNewLineDelimiter() {		
		String numbers = "2\n1000";
		assertEquals("Sum should be 1002", 1002, stringCalculator.add(numbers));		
		numbers = null;
	}
	
	/** 
	 * Test for above upper limit (1000) in the input with newline delimiter
	 */	
	@Test
	public void testAddNumbersWithGreaterThanThousandNewLineDelimiter() {		
		String numbers = "2\n1001";
		assertEquals("Sum should be 2", 2, stringCalculator.add(numbers));		
		numbers = null;
	}	
	
	/** 
	 * Test for multiple numbers with comma and newline delimiter
	 */	
	@Test
	public void testAddNumbersCommaAndNewLineDelimiter() {		
		String numbers = "1\n2,3";
		assertEquals("Sum should be 6", 6, stringCalculator.add(numbers));		
		numbers = null;
	}
	
	/** 
	 * Test for single negative number in the input with comma and newline delimiter
	 */
	@Test
	public void testAddNegativeNumbersCommaAndNewLineDelimiterThrowExceptionCheckErrorMessage() {	
		exceptionRule.expect(IllegalArgumentException.class);
		exceptionRule.expectMessage("negatives not allowed : [-2]");
		String numbers = "1,-2\n3";
		stringCalculator.add(numbers);		
	}
	
	/** 
	 * Test for multiple negative number in the input with comma and newline delimiter
	 */
	@Test
	public void testAddMultipleNegativeNumbersCommaAndNewLineDelimiterThrowExceptionCheckErrorMessage() {	
		exceptionRule.expect(IllegalArgumentException.class);
		exceptionRule.expectMessage("negatives not allowed : [-2, -3]");
		String numbers = "1,-2\n-3";
		stringCalculator.add(numbers);		
	}
	
	/** 
	 * Test for upper limit (1000) in the input with comma and newline delimiter
	 */	
	@Test
	public void testAddNumbersWithThousandCommaAndNewLineDelimiter() {		
		String numbers = "1\n1000,2";
		assertEquals("Sum should be 1003", 1003, stringCalculator.add(numbers));		
		numbers = null;
	}
	
	/** 
	 * Test for above upper limit (1000) in the input with comma and newline delimiter
	 */	
	@Test
	public void testAddNumbersWithGreaterThanThousandCommaAndNewLineDelimiter() {		
		String numbers = "1,2\n1001";
		assertEquals("Sum should be 3", 3, stringCalculator.add(numbers));		
		numbers = null;
	}

	/** 
	 * Destroy the objects after the tests
	 */
	@After
	public void destroy() {
		stringCalculator = null;
		exceptionRule = null;
	}
	
}
