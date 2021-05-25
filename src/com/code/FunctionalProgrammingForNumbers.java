package com.code;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

@SuppressWarnings( "SimplifyStreamApiCallChains" ) public class FunctionalProgrammingForNumbers {

	public static void main( String[] args ) {
		FunctionalProgrammingForNumbers
				functionalProgramming = new FunctionalProgrammingForNumbers();
		//		functionalProgramming.streamFromArray();
		//		functionalProgramming.streamCreate();
		//		functionalProgramming.BigNumber();
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

	private void BigNumber() {
		// overflow happens when the numbers are large.
		System.out.println( LongStream.range( 1, 50 ).reduce( 1L, ( x, y ) -> x * y ) );
		// solution: use BigInteger.
		System.out.println( LongStream.range( 1, 50 ).mapToObj( BigInteger::valueOf )
				.reduce( BigInteger.ONE, BigInteger::multiply ) );
	}
}