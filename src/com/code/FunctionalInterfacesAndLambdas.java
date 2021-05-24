package com.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@SuppressWarnings( { "Convert2MethodRef", "SimplifyStreamApiCallChains" } )
public class FunctionalInterfacesAndLambdas {

	public static void main( String[] args ) {
		FunctionalInterfacesAndLambdas functionalInterfacesAndLambdas =
				new FunctionalInterfacesAndLambdas();
		//		functionalInterfacesAndLambdas.functionalInterfacesBasics();
		//		functionalInterfacesAndLambdas.behaviourParametrizationBasics();
		//		functionalInterfacesAndLambdas.behaviourParametrization();
		functionalInterfacesAndLambdas.supplier();

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
		// this keyword can be used to use methods of current class.
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

	@SuppressWarnings( "all" )
	private void predicate() {
		// this is created automatically when you use predicate.
		// this is to support older versions of java.
		Predicate<Integer> isEvent = new Predicate<Integer>() {

			@Override public boolean test( Integer x ) {
				return x % 2 == 0;
			}
		};
	}

	@SuppressWarnings( "all" )
	private void function() {
		// represent a function that accepts one argument & produce a result.
		// Inside angle bracket,the first type is of input & the next type is of result.
		Function<Integer, Integer> square = new Function<Integer, Integer>() {

			@Override public Integer apply( Integer x ) {
				return x * x;
			}
		};
	}

	@SuppressWarnings( "all" )
	private void consumer() {
		// accepts a single argument & returns no result.
		// consumes input.

		Consumer<Integer> sysOut = new Consumer<Integer>() {

			@Override public void accept( Integer x ) {
				System.out.println( x );
			}
		};
	}

	@SuppressWarnings( "all" )
	private void binaryOperator() {
		// reduce(0, Integer::sum).
		// Operator takes input & output of same type.

		BinaryOperator<Integer> sum = new BinaryOperator<>() {

			@Override public Integer apply( Integer a, Integer b ) {
				return a + b;
			}
		};
	}

	private void behaviourParametrizationBasics() {

		// duplicate code exists. only filter is changed here (behaviour changes).
		numbers.stream().filter( x -> x % 2 == 0 ).forEach( System.out::println );
		numbers.stream().filter( x -> x % 2 != 0 ).forEach( System.out::println );
		// solution: extract predicate and use it (behaviour parametrization).

		Predicate<Integer> even = x -> x % 2 == 0;
		Predicate<Integer> odd = x -> x % 2 != 0;
		filterAndPrint( numbers, even );
		filterAndPrint( numbers, odd );

	}

	private static void filterAndPrint( List<Integer> numbers, Predicate<Integer> predicate ) {
		numbers.stream().filter( predicate ).forEach( System.out::println );
	}

	private void behaviourParametrization() {
		// function is passed as a parameter.
		Function<Integer, Integer> mappingFunction = x -> x * x;
		map( numbers, mappingFunction ).stream().forEach( System.out::println );
	}

	private static List<Integer> map( List<Integer> numbers,
			Function<Integer, Integer> mappingFunction ) {
		return numbers.stream().map( mappingFunction ).collect( Collectors.toList() );
	}

	// predicate -> boolean result.
	// function -> input & output.
	// consumer -> no output.
	// operator -> input & output of same type.
	// binary operator -> 2 input & output.
	// supplier -> no input & returns something back.

	private void supplier() {
		// no parameter in input. returns 2.
		Supplier<Integer> integerSupplier = () -> 2;

		Supplier<Integer> randomIntegerSupplier = () -> {
			Random random = new Random();
			return random.nextInt( 1000 );
		};

		System.out.println( integerSupplier.get() );
		for ( int i = 0; i < 10; i++ )
			System.out.println( randomIntegerSupplier.get() );

	}
}