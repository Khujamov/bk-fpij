package us.cyzic.fpij.compare;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class OlderThan20 {

	public static void main(String[] args) {
		
		final List<Person> people = Compare.people;
		
		List<Person> olderThan20Fugly = new ArrayList<>();
		
		people.stream()
			.filter(person -> person.getAge() > 20)
			.forEach(person -> olderThan20Fugly.add(person));

		System.out.println("People older than 20 (the Fugly way): " + olderThan20Fugly);
		System.out.println();
		
		final List<Person> olderThan20Better =
				people.stream()
					.filter(person -> person.getAge() > 20)
					.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		
		System.out.println("People older than 20 using ArrayList::new, add, and addAll: " + olderThan20Better);
		System.out.println();
		
		final List<Person> olderThan20Best =
				people.stream()
					.filter(person -> person.getAge() > 20)
					.collect(Collectors.toList());
		
		System.out.println("People older than 20 using Collectors.toList(): " + olderThan20Best);
		System.out.println();
		
		Map<Integer, List<Person>> peopleByAge =
				people.stream()
					.collect(Collectors.groupingBy(Person::getAge));
		System.out.println("Grouped by age: " + peopleByAge);
		System.out.println();
		
		Map<Integer, List<String>> nameOfPeopleByAge =
				people.stream()
					.collect(
					  groupingBy(Person::getAge, mapping(Person::getName, toList())));
		System.out.println("People's names grouped by age: " + nameOfPeopleByAge);
		System.out.println();
		
		Comparator<Person> byAge = Comparator.comparing(Person::getAge);
		Map<Character, Optional<Person>> oldestPersonOfEachLetter =
			people.stream()
				.collect(groupingBy(person -> person.getName().charAt(0),
						reducing(BinaryOperator.maxBy(byAge))));
		
		System.out.println("Oldest person of each letter:");
		System.out.println(oldestPersonOfEachLetter);
	}

}
