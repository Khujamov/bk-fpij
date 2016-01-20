package us.cyzic.fpij.compare;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Compare {

	final static List<Person> myPeeps = Arrays.asList(
			new Person("John", 20),
			new Person("Sara", 21),
			new Person("Jane", 21),
			new Person("Greg", 35));
	
	public static void main(String[] args) {
		
		final List<Person> ascendingAge = myPeeps.stream()
				.sorted((person1, person2) -> person1.ageDifference(person2))
				.collect(Collectors.toList());
		printPeople("Sorted in ascending order by age:", ascendingAge);
		
		final List<Person> ascendingAge2 = 
				myPeeps.stream()
					.sorted(Person::ageDifference)
					.collect(Collectors.toList());
		printPeople("Sorted in ascending order by age (via method reference):", ascendingAge2);

		final List<Person> descendingAge =
				myPeeps.stream()
					.sorted((person1, person2) -> person2.ageDifference(person1))
					.collect(Collectors.toList());
		
		printPeople("Sorted in descending order by changing lambda expression:", descendingAge);
		
		Comparator<Person> compareAscending =
				(person1, person2) -> person1.ageDifference(person2);
		Comparator<Person> compareDescending = compareAscending.reversed();
		
		final List<Person> ascendingAge3 =
				myPeeps.stream()
					.sorted(compareAscending)
					.collect(Collectors.toList());
		
		printPeople("Sorted in ascending order via declared Comparator: ", ascendingAge3);
		
		final List<Person> descendingAge2 =
				myPeeps.stream()
					.sorted(compareDescending)
					.collect(Collectors.toList());
		printPeople("Sorted in descending order by other declared Comparator:", descendingAge2);
		
		printPeople("Sorted in ascending order by name:", 
				myPeeps.stream()
					.sorted((person1, person2) -> person1.getName().compareTo(person2.getName()))
					.collect(Collectors.toList()));
		
		myPeeps.stream()
			.min(Person::ageDifference)
			.ifPresent(youngest -> System.out.println("Youngest: " + youngest));
		
		myPeeps.stream()
			.max(Person::ageDifference)
			.ifPresent(oldest -> System.out.println("Oldest: " + oldest));
	}
	
	public static void printPeople(final String message, final List<Person> people) {
		System.out.println(message);
		people.forEach(System.out::println);
		System.out.println();
	}

}
