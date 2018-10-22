package com.stringaccumulator.assignment;

public interface StringCalculator {
	
	/** 
	 * Sum the numbers in the argument. 
	 * Parse the input and split the numbers using delimiter, if the argument contains the delimiter. 
	 * Otherwise, split the numbers using the default delimiter.
	 * @param numbers
	 * @return
	 */
	int add(String numbers);
	
}
