package com.stringaccumulator.assignment.service;

import static java.util.Optional.ofNullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.stringaccumulator.assignment.StringCalculator;

public class SimpleStringCalculator implements StringCalculator {

	private static final String DEFAULT_DELIMITER = "\\,|\\\n";
	private static final int ZERO = 0;
	private static final int UPPER_LIMIT = 1001;
			
	/**
	 * Sum the numbers in the argument. 
	 * Parse the input and split the numbers using the default delimiter.
	 * @see com.stringaccumulator.assignment.StringCalculator#add(java.lang.String)
	 */
	@Override
	public int add(String numbers) {
		return add(numbers, DEFAULT_DELIMITER);
	}
	
	/**
	 * Sum the numbers in the argument. 
	 * Parse the input and split the numbers using delimiter provided in the argument.
	 * @param numbers
	 * @param delimiter 
	 * @return
	 */
	protected int add(final String numbers, final String delimiter) {		
		/* 
		 * Split the numbers using the delimiter. 
		 * Trim and filter the empty string
		 * Convert the Stream<String> to Stream<Integer>
		 * Apply the upper limit filter
		 * Group the numbers based on the sign
		 */
		 Map<Boolean, List<Integer>> numbersMap= Arrays.stream(numbers.split(delimiter))
			 		.map(String::trim)
					.filter( s-> !s.isEmpty())
					.flatMap(s-> Stream.of(Integer.valueOf(s)))
					.filter(SimpleStringCalculator::applyUpperLimitFilter)
					.collect(Collectors.groupingBy(SimpleStringCalculator::groupByUsingSign));
		 /*
		  * Check, if negative values present
		  * Throw exception, when negative values present
		  * Otherwise, sum the numbers
		  */
		 if(ofNullable(numbersMap.get(true)).isPresent()) {
			 throw new IllegalArgumentException("negatives not allowed : " + numbersMap.get(true));
		 }
		 else {
			 return ofNullable(numbersMap.get(false)).orElseGet(ArrayList<Integer>::new).stream().mapToInt(i -> i).sum();			 
		 }				
	}
	
	/**
	 * Check the number is within the limit
	 * @param number
	 * @return
	 */
	private static boolean applyUpperLimitFilter(Integer number) {
		return number < UPPER_LIMIT;
	}
	
	/**
	 * Check the sign (if the number is positive or negative) 
	 * @param number
	 * @return
	 */
	private static boolean groupByUsingSign(Integer number) {
		return number < ZERO;
	}
	
}
