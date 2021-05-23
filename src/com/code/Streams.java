package com.code;

import java.util.List;

public class Streams {

	public static void main( String[] args ) {
		Streams stream = new Streams();
		stream.addListOfNumbers();
	}

	List<Integer> numbers = List.of( 12, 9, 13, 4, 15 );
	List<String> courses = List.of( "Spring Boot", "Java", "Python", "Spring" );

	@SuppressWarnings( "Convert2MethodRef" ) private void addListOfNumbers() {
		int sum1 = numbers.stream().reduce( 0, ( a, b ) -> a + b );
		int sum2 = numbers.stream().reduce( 0, Integer::sum );
		System.out.println( sum1 );
		System.out.println( sum2 );
	}
}