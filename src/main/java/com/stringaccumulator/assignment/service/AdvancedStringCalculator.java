package com.stringaccumulator.assignment.service;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class AdvancedStringCalculator extends SimpleStringCalculator {

	private static final String INPUT_DELIMITER_PREFIX = "//";
	private static final String DELIMITER_NUMBERS_SEPARATOR = "\n";		
	private static final String ESCAPE_CHARACTERS = "\\.[]{}()<>*+-=?^$";
	
	/**
	 * Sum the numbers in the argument. 
	 * Parse the input and split the numbers using delimiter in the input. 
	 * @see com.stringaccumulator.assignment.service.SimpleStringCalculator#add(java.lang.String)
	 */
	@Override
	public int add(String numbers) {
		return (numbers.startsWith(INPUT_DELIMITER_PREFIX)
					? add(getNumbers(numbers), getDelimiter(numbers)) 
					: super.add(numbers));
	}
	
	/**
	 * Parse the input and get the delimiter
	 * @param numbers
	 * @return
	 */
	private String getDelimiter(String numbers) {
		return getEscapedDelimiter(numbers.substring(INPUT_DELIMITER_PREFIX.length(), 
									numbers.indexOf(DELIMITER_NUMBERS_SEPARATOR)));	
	}	
	
	/**
	 * Split the input and get the text to be parsed, excluding the delimiter pattern text.
	 * @param numbers
	 * @return
	 */
	private String getNumbers(String numbers) {
		return numbers.substring(numbers.indexOf(DELIMITER_NUMBERS_SEPARATOR)+1);
	}
	
	/**
	 * Escape the delimiter, if any regular expression special characters found
	 * @param delimiter
	 * @return
	 */
	private String getEscapedDelimiter(String delimiter) {		
		return Arrays.stream(delimiter.split(""))
						.map(s -> (ESCAPE_CHARACTERS.contains(s) ? Pattern.quote(s): s))
						.collect(Collectors.joining());
	}
	
}

