package com.code;

import java.util.List;

@SuppressWarnings( "Convert2MethodRef" ) public class Streams {

	public static void main( String[] args ) {
		Streams stream = new Streams();
		//		stream.addListOfNumbers();
		//		stream.addListOfNumbersCases();
		//		stream.squareAndSum();
		//		stream.sumOfOddNumbers();
		//		stream.printDistinctNumbers();
		stream.sortNumbers();
	}

	List<Integer> numbers = List.of( 12, 9, 13, 4, 15 );
	List<String> courses = List.of( "Spring Boot", "Java", "Python", "Spring" );

	private void addListOfNumbers() {
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

	private void squareAndSum() {
		int result = numbers.stream().map( number -> number * number )
				.reduce( 0, ( x, y ) -> x + y );
		System.out.println( result );
	}

	private void sumOfOddNumbers() {
		int result = numbers.stream().filter( number -> number % 2 != 0 )
				.reduce( 0, ( x, y ) -> x + y );
		System.out.println( result );
	}

	private void printDistinctNumbers() {
		numbers.stream().distinct().forEach( System.out::println );
	}

	private void sortNumbers() {
		numbers.stream().sorted().forEach( System.out::println );
	}

}