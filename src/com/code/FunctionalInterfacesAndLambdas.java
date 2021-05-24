package com.code;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings( "Convert2MethodRef" ) public class FunctionalInterfacesAndLambdas {

	public static void main( String[] args ) {
		FunctionalInterfacesAndLambdas functionalInterfacesAndLambdas =
				new FunctionalInterfacesAndLambdas();
		functionalInterfacesAndLambdas.functionalInterfaces();

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

	private void functionalInterfaces() {
		numbers.stream().filter( x -> x % 2 == 0 ).map( x -> x * x )
				.forEach( System.out::println );
		numbers.stream().filter( x -> isEven( x ) ).map( x -> x * x )
				.forEach( x -> System.out.println( x ) );
		numbers.stream().filter( this::isEven ).map( x -> x * x )
				.forEach( System.out::println );
	}

	private boolean isEven( int x ) {
		return x % 2 == 0;
	}
}