package com.code;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings( "SimplifyStreamApiCallChains" ) public class CustomClasses {

	public static void main( String[] args ) {
		CustomClasses customClass = new CustomClasses();
		//		customClass.match();
		customClass.sort();

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
}