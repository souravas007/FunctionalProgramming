package com.code;

import java.util.List;

public class Streams {

	public static void main( String[] args ) {
		Streams stream = new Streams();
		//		stream.addListOfNumbers();
//		stream.addListOfNumbersCases();
		stream.squareAndSum();
	}

	List<Integer> numbers = List.of( 12, 9, 13, 4, 15 );
	List<String> courses = List.of( "Spring Boot", "Java", "Python", "Spring" );

	@SuppressWarnings( "Convert2MethodRef" ) private void addListOfNumbers() {
		int sum1 = numbers.stream().reduce( 0, ( a, b ) -> a + b );
		int sum2 = numbers.stream().reduce( 0, Integer::sum );
		System.out.println( sum1 );
		System.out.println( sum2 );
	}

	private void addListOfNumbersCases() {
		int firstNumber = numbers.stream().reduce( 0, ( x, y ) -> x );
		int lastNumber = numbers.stream().reduce( 0, ( x, y ) -> y );
		int maxPositiveNumber =
				numbers.stream().reduce( 0, ( x, y ) -> x > y ? x : y );
		int maxNumber =
				numbers.stream().reduce( Integer.MIN_VALUE, ( x, y ) -> x > y ? x : y );
		System.out.println( firstNumber );
		System.out.println( lastNumber );
		System.out.println( maxPositiveNumber );
		System.out.println( maxNumber );
	}

	@SuppressWarnings( "Convert2MethodRef" ) private void squareAndSum() {
		int result = numbers.stream().map( number -> number * number )
				.reduce( 0, ( x, y ) -> x + y );
		System.out.println( result );
	}


}