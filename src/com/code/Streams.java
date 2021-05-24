package com.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings( { "Convert2MethodRef", "SimplifyStreamApiCallChains", "Java8ListSort" } )
public class Streams {

	public static void main( String[] args ) {
		Streams stream = new Streams();
		stream.createEmployee();
		//				stream.addListOfNumbers();
		//				stream.addListOfNumbersCases();
		//				stream.squareAndSum();
		//				stream.sumOfOddNumbers();
		//				stream.printDistinctNumbers();
		//				stream.sortNumbers();
		//				stream.sortStrings();
		//				stream.sortObjects();
		//				stream.squareNumbersList();
		//				stream.evenNumberFiltered();
		//				stream.listWithLengthOfCourseTitles();
	}

	List<Integer> numbers = List.of( 12, 9, 13, 4, 15 );
	List<String> courses = List.of( "Spring Boot", "Java", "Python", "Spring" );

	List<Employee> employees = new ArrayList<>();

	private void createEmployee() {
		employees.add( new Employee( "Sourav", "A S" ) );
		employees.add( new Employee( "Sourav", "S" ) );
		employees.add( new Employee( "Akash", "Nath" ) );
		employees.add( new Employee( "Akash", "Anu" ) );

	}

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

	private void sortStrings() {
		courses.stream().sorted( Comparator.naturalOrder() ).forEach( System.out::println );
		courses.stream().sorted( Comparator.reverseOrder() ).forEach( System.out::println );
	}

	private void sortObjects() {
		// first way. not much flexibility.
		List<Employee> result =
				employees.stream().sorted( Comparator.comparing( Employee::getFirstName )
						.thenComparing( Employee::getLastName ).reversed() )
						.collect( Collectors.toList() );
		result.stream().forEach( System.out::println );

		// second way which I copied from stack over flow. better flexibility.
		Collections.sort( employees, ( s1, s2 ) -> {
			int firstName = s1.getFirstName().compareTo( s2.getFirstName() );
			if ( firstName != 0 )
				return firstName;
			// since this is multi line lambda, return statement is important.
			return s2.getLastName().compareTo( s1.getLastName() );
		} );
		employees.stream().forEach( System.out::println );
	}

	private void squareNumbersList() {
		numbers.stream().map( number -> number * number ).collect( Collectors.toList() )
				.stream().forEach( System.out::println );
	}

	private void evenNumberFiltered() {
		numbers.stream().filter( number -> number % 2 == 0 ).collect( Collectors.toList() )
				.stream().forEach( System.out::println );
	}

	private void listWithLengthOfCourseTitles() {
		courses.stream().map( course -> course.length() ).collect( Collectors.toList() )
				.stream().forEach( System.out::println );
	}

	private void intermediateOperations() {
		// operations that works on stream.
		// returns stream.
		// example: sorted(), distinct(), map(), filter().
	}

	private void terminalOperations() {
		//operations that return something other than stream.
		// example: forEach (return void), collect (return list), reduce (return one element).
	}
}