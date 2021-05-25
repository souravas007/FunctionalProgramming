package com.code;

import java.util.Arrays;
import java.util.stream.Stream;

public class FunctionalProgramming {

	public static void main( String[] args ) {
		FunctionalProgramming functionalProgramming = new FunctionalProgramming();
		functionalProgramming.streamFromArray();
	}

	private void streamFromArray() {
		System.out.println( Stream.of( 12, 9, 13, 4 ).count() );
		int[] numberArray = { 12, 9, 13, 4 };
		System.out.println( Arrays.stream( numberArray ).sum() );

	}
}