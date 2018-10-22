package com.stringaccumulator.assignment.service;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AdvancedStringCalculatorTest extends SimpleStringCalculatorTest {
		
	/** 
	 * Initialize the required objects before the tests  
	 */
	@Before
	public void init() {
		stringCalculator = new AdvancedStringCalculator();
	}
	
	/** 
	 * Test for two numbers with input delimiter prefix *
	 */
	@Test
	public void testAddTwoNumbersPrefixStarDelimiter() {	
		String numbers="//*\n1*2";
		assertEquals("Sum should be 3", 3, stringCalculator.add(numbers));	
		numbers = null;
	}
	
	/** 
	 * Test for multiple numbers with input delimiter prefix *
	 */
	@Test
	public void testAddNumbersPrefixStarDelimiter() {		
		String numbers = "//*\n1*2*3";
		assertEquals("Sum should be 6", 6, stringCalculator.add(numbers));		
	}
	
	/** 
	 * Test for single negative number with input delimiter prefix *
	 */
	@Test
	public void testAddNegativeNumbersPrefixStarDelimiterThrowExceptionCheckErrorMessage() {	
		exceptionRule.expect(IllegalArgumentException.class);
		exceptionRule.expectMessage("negatives not allowed : [-2]");
		String numbers = "//*\n1*-2*3";
		stringCalculator.add(numbers);		
	}
	
	/** 
	 * Test for multiple negative number  with input delimiter prefix *
	 */
	@Test
	public void testAddMultipleNegativeNumbersPrefixStarDelimiterThrowExceptionCheckErrorMessage() {	
		exceptionRule.expect(IllegalArgumentException.class);
		exceptionRule.expectMessage("negatives not allowed : [-2, -3]");
		String numbers = "//*\n1*-2*-3";
		stringCalculator.add(numbers);		
	}
	
	/** 
	 * Test for upper limit (1000) in the input with input delimiter prefix *
	 */	
	@Test
	public void testAddNumbersWithThousandPrefixStarDelimiter() {		
		String numbers = "//*\n2*1000";
		assertEquals("Sum should be 1002", 1002, stringCalculator.add(numbers));		
		numbers = null;
	}
	
	/** 
	 * Test for above upper limit (1000) in the input with input delimiter prefix *
	 */		
	@Test
	public void testAddNumbersWithGreaterThanThousandPrefixStarDelimiter() {		
		String numbers = "//*\n2*1001";
		assertEquals("Sum should be 2", 2, stringCalculator.add(numbers));		
		numbers = null;
	}
	
	/** 
	 * Test for two numbers with input delimiter prefix ***
	 */
	@Test
	public void testAddTwoNumbersPrefixMutipleStarDelimiter() {		
		String numbers = "//***\n1***2";
		assertEquals("Sum should be 3", 3, stringCalculator.add(numbers));		
	}

	/** 
	 * Test for multiple numbers with input delimiter prefix ***
	 */
	@Test
	public void testAddNumbersPrefixMutipleStarDelimiter() {		
		String numbers = "//***\n1***2***3";
		assertEquals("Sum should be 6", 6, stringCalculator.add(numbers));		
	}
	
	/** 
	 * Test for single negative number with input delimiter prefix ***
	 */
	@Test
	public void testAddNegativeNumbersPrefixMutipleStarDelimiterThrowExceptionCheckErrorMessage() {	
		exceptionRule.expect(IllegalArgumentException.class);
		exceptionRule.expectMessage("negatives not allowed : [-2]");
		String numbers = "//***\n1***-2***3";
		stringCalculator.add(numbers);		
	}
	
	/** 
	 * Test for multiple negative number  with input delimiter prefix ***
	 */
	@Test
	public void testAddMultipleNegativeNumbersPrefixMutipleStarDelimiterThrowExceptionCheckErrorMessage() {	
		exceptionRule.expect(IllegalArgumentException.class);
		exceptionRule.expectMessage("negatives not allowed : [-2, -3]");
		String numbers ="//***\n1***-2***-3";
		stringCalculator.add(numbers);		
	}
	
	/** 
	 * Test for upper limit (1000) in the input with input delimiter prefix ***
	 */	
	@Test
	public void testAddNumbersWithThousandPrefixMutipleStarDelimiter() {		
		String numbers = "//***\n2***1000";
		assertEquals("Sum should be 1002", 1002, stringCalculator.add(numbers));		
		numbers = null;
	}
	
	/** 
	 * Test for above upper limit (1000) in the input with input delimiter prefix ***
	 */		
	@Test
	public void testAddNumbersWithGreaterThanThousandPrefixMultipleStarDelimiter() {		
		String numbers = "//***\n2***1001";
		assertEquals("Sum should be 2", 2, stringCalculator.add(numbers));		
		numbers = null;
	}
	
	/** 
	 * Test for multiple numbers with input delimiter prefix multiple delimiters *%
	 */
	@Test
	public void testAddNumbersPrefixStarAndPercentageDelimiter() {		
		String numbers = "//*|%\n1*2%3";
		assertEquals("Sum should be 6", 6, stringCalculator.add(numbers));		
	}
		
	/** 
	 * Test for single negative number with input delimiter prefix multiple delimiters *%
	 */
	@Test
	public void testAddNegativeNumbersPrefixStarAndPercentageDelimiterThrowExceptionCheckErrorMessage() {	
		exceptionRule.expect(IllegalArgumentException.class);
		exceptionRule.expectMessage("negatives not allowed : [-2]");
		String numbers = "//*|%\n1*-2%3";
		stringCalculator.add(numbers);		
	}
	
	/** 
	 * Test for multiple negative number  with input delimiter prefix multiple delimiters *%
	 */
	@Test
	public void testAddMultipleNegativeNumbersPrefixStarAndPercentageThrowExceptionCheckErrorMessage() {	
		exceptionRule.expect(IllegalArgumentException.class);
		exceptionRule.expectMessage("negatives not allowed : [-2, -3]");
		String numbers = "//*|%\n1*-2%-3";
		stringCalculator.add(numbers);		
	}
	
	/** 
	 * Test for upper limit (1000) in the input with input delimiter prefix multiple delimiters *%
	 */	
	@Test
	public void testAddNumbersWithThousandPrefixStarAndPercentageDelimiter() {		
		String numbers = "//*|%\n1*2%1000";
		assertEquals("Sum should be 1003", 1003, stringCalculator.add(numbers));		
		numbers = null;
	}
	
	/** 
	 * Test for above upper limit (1000) in the input with input delimiter prefix multiple delimiters *%
	 */		
	@Test
	public void testAddNumbersWithGreaterThanThousandPrefixStarAndPercentageDelimiter() {		
		String numbers = "//*|%\n1*2%1001";
		assertEquals("Sum should be 3", 3, stringCalculator.add(numbers));		
		numbers = null;
	}
	
	/** 
	 * Test for multiple numbers with input delimiter prefix multiple delimiters ***%%
	 */
	@Test
	public void testAddNumbersPrefixMultipleStarAndPercentageDelimiter() {		
		String numbers = "//***|%%\n1***2%%3";
		assertEquals("Sum should be 6", 6, stringCalculator.add(numbers));		
	}
	
	/** 
	 * Test for single negative number with input delimiter prefix multiple delimiters  ***%%
	 */
	@Test
	public void testAddNegativeNumbersPrefixMultipleStarAndPercentageDelimiterThrowExceptionCheckErrorMessage() {	
		exceptionRule.expect(IllegalArgumentException.class);
		exceptionRule.expectMessage("negatives not allowed : [-2]");
		String numbers = "//***|%%\n1***-2%%3";
		stringCalculator.add(numbers);		
	}
	
	/** 
	 * Test for multiple negative number  with input delimiter prefix multiple delimiters  ***%%
	 */
	@Test
	public void testAddMultipleNegativeNumbersPrefixMultipleStarAndPercentageThrowExceptionCheckErrorMessage() {	
		exceptionRule.expect(IllegalArgumentException.class);
		exceptionRule.expectMessage("negatives not allowed : [-2, -3]");
		String numbers = "//***|%%\n1***-2%%-3";
		stringCalculator.add(numbers);		
	}
	
	/** 
	 * Test for upper limit (1000) in the input with input delimiter prefix multiple delimiters  ***%%
	 */	
	@Test
	public void testAddNumbersWithThousandPrefixMultipleStarAndPercentageDelimiter() {		
		String numbers = "//***|%%\n1***2%%1000";
		assertEquals("Sum should be 1003", 1003, stringCalculator.add(numbers));		
		numbers = null;
	}
	
	/** 
	 * Test for above upper limit (1000) in the input with input delimiter prefix multiple delimiters  ***%%
	 */		
	@Test
	public void testAddNumbersWithGreaterThanThousandPrefixMultipleStarAndPercentageDelimiter() {		
		String numbers = "//***|%%\n1***2%%1001";
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
