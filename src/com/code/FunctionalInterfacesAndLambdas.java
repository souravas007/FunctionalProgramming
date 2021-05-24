package com.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

@SuppressWarnings( { "Convert2MethodRef", "SimplifyStreamApiCallChains", "CodeBlock2Expr" } )
public class FunctionalInterfacesAndLambdas {

	public static void main( String[] args ) {
		FunctionalInterfacesAndLambdas functionalInterfacesAndLambdas =
				new FunctionalInterfacesAndLambdas();
		//		functionalInterfacesAndLambdas.functionalInterfacesBasics();
		//		functionalInterfacesAndLambdas.behaviourParametrizationBasics();
		//		functionalInterfacesAndLambdas.behaviourParametrization();
		//		functionalInterfacesAndLambdas.supplier();
		//		functionalInterfacesAndLambdas.unaryOperator();
		//		functionalInterfacesAndLambdas.biPredicate();
		//		functionalInterfacesAndLambdas.biFunction();
		//		functionalInterfacesAndLambdas.biConsumer();
		//		functionalInterfacesAndLambdas.binaryOperatorForPrimitives();
		functionalInterfacesAndLambdas.methodReferences();

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

	/*
	predicate -> boolean result.
	function -> input & output.
	consumer -> no output.
	operator -> input & output of same type.
	binary operator -> 2 input & output.
	supplier -> no input & returns something back.
	unary operator -> 1 input and 1 output of same type.
	bi-predicate -> 2 input & 1 boolean output.
	bi-function -> 2 input & 1 output which can be of any type.
	bi-consumer -> 2 input & consumes it.
	*/
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

	private void supplier() {
		// no parameter in input. returns something back.
		Supplier<Integer> integerSupplier = () -> 2;

		Supplier<Integer> randomIntegerSupplier = () -> {
			Random random = new Random();
			return random.nextInt( 1000 );
		};

		System.out.println( integerSupplier.get() );
		for ( int i = 0; i < 10; i++ )
			System.out.println( randomIntegerSupplier.get() );

	}

	private void unaryOperator() {
		// 1 input and 1 output of same type.
		UnaryOperator<Integer> unary = x -> x * x;
		System.out.println( unary.apply( 3 ) );
	}

	private void biPredicate() {
		// 2 input & 1 boolean output.
		// only 1 line is there, hence, return statement not required.
		BiPredicate<Integer, String> biPredicateTrue = ( number, string ) -> true;
		// multiple lines. Hence, return statement is required.
		BiPredicate<Integer, String> biPredicate = ( number, str ) -> {
			return number < 10 && str.length() > 5;
		};
		System.out.println( biPredicateTrue.test( 12, "hello" ) );
		System.out.println( biPredicate.test( 5, "Sourav" ) );
		System.out.println( biPredicate.test( 11, "Sourav" ) );
	}

	private void biFunction() {
		// 2 input & 1 output which can be of any type.
		BiFunction<Integer, String, String> biFunction = ( number, str ) -> {
			return number + " " + str;
		};
		System.out.println( biFunction.apply( 12, "Sourav" ) );

	}

	private void biConsumer() {
		// 2 inputs & consumes it.
		BiConsumer<String, String> biConsumer = ( s1, s2 ) -> {
			System.out.println( s1 );
			System.out.println( s2 );
		};
		biConsumer.accept( "Hello, ", "World!" );
	}

	private void binaryOperatorForPrimitives() {
		// binary operators are used for int, long etc.
		// it does autoboxing and unboxing which makes it inefficient.
		// use int, long etc. to avoid autoboxing and unboxing and increase efficiency.
		IntBinaryOperator intBinaryOperator = ( x, y ) -> x + y;
		// use primitive operators when you're working with primitives.
		System.out.println( intBinaryOperator.applyAsInt( 1, 3 ) );
	}

	private void type() {
		Predicate<Integer> isEven = ( Integer x ) -> x % 2 == 0;
		// type can be added. it's not necessary since it can be inferred.
	}

	@SuppressWarnings( "StringOperationCanBeSimplified" ) private void methodReferences() {
		courses.stream().map( str -> str.toUpperCase() ).forEach( System.out::println );
		courses.stream().map( String::toUpperCase ).forEach( System.out::println );
		// method references work on static methods and methods on object (this::methodName).
		Supplier<String> supplier = String::new;
		Supplier<String> supplier1 = () -> new String();
		System.out.println( supplier.get() );
		System.out.println( supplier1.get() );
	}
}