package com.code;

import java.util.List;

public class Main {

	public static void main( String[] args ) {
		Main main = new Main();
		//		main.printNumbersInListTraditional();
		//		main.printNumberInListFunctionalProgramming();
		//		main.printEvenNumbers();
		//		main.printOddNumbers();
		main.wordsContainingSequence();
	}

	List<Integer> numbers = List.of( 12, 9, 13, 4, 15 );
	List<String> courses = List.of( "Spring Boot", "Java", "Python", "Spring" );

	private void printNumbersInListTraditional() {
		for ( Integer number : numbers ) {
			System.out.println( number );
		}
	}

	@SuppressWarnings( { "SimplifyStreamApiCallChains", "Convert2MethodRef" } )
	private void printNumberInListFunctionalProgramming() {
		numbers.stream().forEach( System.out::println );
		numbers.stream().forEach( number -> System.out.println( number ) );
	}

	private void printEvenNumbers() {
		numbers.stream().filter( x -> x % 2 == 0 ).forEach( System.out::println );
	}

	private void printOddNumbers() {
		numbers.stream().filter( x -> x % 2 != 0 ).forEach( System.out::println );
	}

	private void wordsContainingSequence() {
		courses.stream().filter( course -> course.contains( "Spring" ) )
				.forEach( System.out::println );
	}
}