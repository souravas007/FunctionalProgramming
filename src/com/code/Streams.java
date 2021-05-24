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
		//		stream.addListOfNumbers();
		//		stream.addListOfNumbersCases();
		//		stream.squareAndSum();
		//		stream.sumOfOddNumbers();
		//		stream.printDistinctNumbers();
		//		stream.sortNumbers();
		//		stream.sortStrings();
//		stream.sortObjects();
		stream.squareNumbersList();
	}

	List<Integer> numbers = List.of( 12, 9, 13, 4, 15 );
	List<String> courses = List.of( "Spring Boot", "Java", "Python", "Spring" );

	class Employee {

		String firstName;
		String lastName;

		public Employee( String firstName, String lastName ) {
			this.firstName = firstName;
			this.lastName = lastName;
		}

		@Override public String toString() {
			return "Employee{" +
					"firstName='" + firstName + '\'' +
					", lastName='" + lastName + '\'' +
					'}';
		}

		public String getFirstName() {
			return firstName;
		}

		public String getLastName() {
			return lastName;
		}
	}

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
		List<Employee> result =
				employees.stream().sorted( Comparator.comparing( Employee::getFirstName )
						.thenComparing( Employee::getLastName ).reversed() )
						.collect( Collectors.toList() );
		result.stream().forEach( System.out::println );
		Collections.sort( employees, ( s1, s2 ) -> {
			int firstName = s1.getFirstName().compareTo( s2.getFirstName() );
			if ( firstName != 0 )
				return firstName;
			return s2.getLastName().compareTo( s1.getLastName() );
		} );
		employees.stream().forEach( System.out::println );
	}

	private void squareNumbersList() {
		numbers.stream().map( number -> number * number ).collect( Collectors.toList() )
				.stream().forEach( System.out::println );
	}
}