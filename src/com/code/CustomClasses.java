package com.code;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings( "SimplifyStreamApiCallChains" ) public class CustomClasses {

	public static void main( String[] args ) {
		CustomClasses customClass = new CustomClasses();
		//		customClass.match();
		//		customClass.sort();
		//		customClass.limit();
		//		customClass.skip();
		//		customClass.skipLimit();
		//		customClass.takeWhile();
		customClass.dropWhile();

	}

	List<Course> courses = List.of(
			new Course( "Spring", "Framework", 98, 1000 ),
			new Course( "Java", "Language", 88, 300 ),
			new Course( "Python", "Language", 55, 100 ),
			new Course( "React", "Framework", 88, 150 )
	);

	private void match() {
		// all match -> true if everything matches this condition.
		// none match -> true if none matches this condition.
		// any match -> true if any matches this condition.
		System.out.println(
				courses.stream().allMatch( course -> course.getReviewScore() > 95 ) );
		System.out
				.println(
						courses.stream().noneMatch( course -> course.getReviewScore() > 95 ) );
		System.out.println(
				courses.stream().anyMatch( course -> course.getReviewScore() > 95 ) );

	}

	private void sort() {
		// give Course in angular brackets.
		Comparator<Course> comparatorNoOfStudents =
				Comparator.comparing( Course::getNoOfStudents );
		courses.stream().sorted( comparatorNoOfStudents ).collect( Collectors.toList() )
				.stream()
				.forEach( System.out::println );
		Comparator<Course> comparatorNoOfStudentsReversed =
				Comparator.comparing( Course::getNoOfStudents ).reversed();
		courses.stream().sorted( comparatorNoOfStudentsReversed )
				.collect( Collectors.toList() ).stream()
				.forEach( System.out::println );
		Comparator<Course> comparatorNoOfStudentsAndReviewScoreReversed =
				Comparator.comparing( Course::getNoOfStudents )
						.thenComparing( Course::getReviewScore ).reversed();
		courses.stream().sorted( comparatorNoOfStudentsAndReviewScoreReversed )
				.collect( Collectors.toList() ).stream()
				.forEach( System.out::println );
	}

	private void limit() {
		// limit -> only top n results are shown.
		Comparator<Course> comparator = Comparator.comparing( Course::getNoOfStudents );
		courses.stream().sorted( comparator ).limit( 3 ).collect( Collectors.toList() )
				.stream().forEach( System.out::println );
	}

	private void skip() {
		// skip -> top n results are skipped
		Comparator<Course> comparator = Comparator.comparing( Course::getNoOfStudents );
		courses.stream().sorted( comparator ).skip( 2 ).forEach( System.out::println );
	}

	private void skipLimit() {
		Comparator<Course> comparator = Comparator.comparing( Course::getReviewScore )
				.thenComparing( Course::getNoOfStudents ).reversed();
		courses.stream().sorted( comparator ).skip( 1 ).limit( 2 )
				.forEach( System.out::println );
	}

	private void takeWhile() {
		// take the elements as long as the condition is true.
		// if condition becomes false, skips the remaining elements.
		courses.stream().takeWhile( course -> course.getReviewScore() > 95 )
				.forEach( System.out::println );
	}

	private void dropWhile() {
		// drop the elements as long as the condition is true.
		// once the condition is met, it will take all the remaining elements.
		courses.stream().dropWhile( course -> course.getReviewScore() > 95 )
				.forEach( System.out::println );
	}

}