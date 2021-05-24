package com.code;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@SuppressWarnings( "Convert2MethodRef" ) public class FunctionalInterfacesAndLambdas {

	public static void main( String[] args ) {
		FunctionalInterfacesAndLambdas functionalInterfacesAndLambdas =
				new FunctionalInterfacesAndLambdas();
		functionalInterfacesAndLambdas.functionalInterfacesBasics();

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

	private void functionalInterfacesBasics() {
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

	private void functionalInterfaces() {
		// has one abstract method.
		Predicate<Integer> isEvent = x -> x % 2 == 0;
		Function<Integer, Integer> square = x -> x * x;
		Consumer<Integer> sysOut = System.out::println;
	}

	private void Predicate() {
		// this is created automatically when you use predicate.
		// this is to support older versions of java.
		Predicate<Integer> isEvent = new Predicate<Integer>() {

			@Override public boolean test( Integer x ) {
				return x % 2 == 0;
			}
		};
	}

	private void Function() {
		// represent a function that accepts one argument & produce a result.
		// Inside angle bracket,the first type is of input & the next type is of result.
		Function<Integer, Integer> square = new Function<Integer, Integer>() {

			@Override public Integer apply( Integer x ) {
				return x * x;
			}
		};
	}
}