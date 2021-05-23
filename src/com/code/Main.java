package com.code;

import java.util.List;

public class Main {

	public static void main( String[] args ) {
		Main main = new Main();
		//		main.printNumbersInListTraditional();
		//		main.printNumberInListFunctionalProgramming();
		main.printEvenNumbers();
		main.printOddNumbers();
	}

	List<Integer> numbers = List.of( 12, 9, 13, 4, 15 );

	private void printNumbersInListTraditional() {
		for ( Integer number : numbers ) {
			System.out.println( number );
		}
	}

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

}