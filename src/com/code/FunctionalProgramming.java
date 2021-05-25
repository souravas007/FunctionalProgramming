package com.code;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@SuppressWarnings( "SimplifyStreamApiCallChains" ) public class FunctionalProgramming {

	public static void main( String[] args ) {
		FunctionalProgramming functionalProgramming = new FunctionalProgramming();
		//		functionalProgramming.streamFromArray();
		functionalProgramming.streamCreate();
	}

	private void streamFromArray() {
		System.out.println( Stream.of( 12, 9, 13, 4 ).count() );
		int[] numberArray = { 12, 9, 13, 4 };
		System.out.println( Arrays.stream( numberArray ).sum() );
	}

	private void streamCreate() {
		// includes 1 and excludes 10.
		System.out.println( IntStream.range( 1, 10 ).sum() );
		// (1, e->e+2) -> creates an infinite loop.
		// limit -> stops infinite loop.
		// peek -> prints the output.
		// System.out.println() -> used to print the final sum.
		System.out.println(
				IntStream.iterate( 1, e -> e + 2 ).limit( 10 ).peek( System.out::println )
						.sum() );

		// boxed -> convert primitive into wrapper class for using with List.
		IntStream.iterate( 2, e -> e * 2 ).limit( 10 ).boxed().collect( Collectors.toList() )
				.stream().forEach( System.out::println );
	}
}