package com.code;

import java.util.List;

public class Main {

	public static void main( String[] args ) {
		Main main = new Main();
		//		main.printNumbersInListTraditional();
		//		main.printNumberInListFunctionalProgramming();
		//		main.printEvenNumbers();
		//		main.printOddNumbers();
		//		main.wordsContainingSequence();
		//		main.wordsContainingFiveLettersOrMore();
		//		main.squareOfEvenNumbers();
		//		main.cubeAllOddNumbers();
		main.printNumberOfCharacters();
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

	private void wordsContainingFiveLettersOrMore() {
		courses.stream().filter( course -> course.length() >= 5 )
				.forEach( System.out::println );
	}

	private void squareOfEvenNumbers() {
		numbers.stream().filter( number -> number % 2 == 0 ).map( number -> number * number )
				.forEach( System.out::println );
	}

	private void cubeAllOddNumbers() {
		numbers.stream().filter( number -> number % 2 != 0 )
				.map( number -> number * number * number ).forEach( System.out::println );
	}

	private void printNumberOfCharacters() {
		courses.stream().map( course -> course + " : " + course.length() )
				.forEach( System.out::println );
	}

}