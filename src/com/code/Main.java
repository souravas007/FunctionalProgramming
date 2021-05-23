package com.code;

import java.util.List;

public class Main {

	public static void main( String[] args ) {
		Main main = new Main();
		main.printNumbersInListTraditional();
		main.printNumberInListFunctionalProgramming();
	}

	private void printNumbersInListTraditional() {
		List<Integer> numbers = List.of( 12, 9, 13, 4, 15 );
		for ( Integer number : numbers ) {
			System.out.println( number );
		}
	}

	private void printNumberInListFunctionalProgramming() {
		List<Integer> numbers = List.of( 12, 9, 13, 4, 15 );
		numbers.stream().forEach( System.out::println );
		numbers.stream().forEach( number -> System.out.println( number ) );
	}

}