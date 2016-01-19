package us.cyzic.fpij.collections;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;
import static us.cyzic.fpij.collections.TransformList.*;

public class FindElements {

	final static List<String> friends = Arrays.asList("Brian", "Nate", "Raju", "Sara", "Scott", "Betty");

	public static void main(String[] args) {

		// A simple filter
		final List<String> sAndBNames = friends.stream().filter(item -> item.startsWith("B") || item.startsWith("S"))
				.collect(Collectors.toList());

		printWithTitle(sAndBNames, "A simple filter");

		// Using a predicate
		final Predicate<String> startsWithS = name -> name.startsWith("S");
		final Predicate<String> startsWithB = name -> name.startsWith("B");

		final List<String> sNames = friends.stream().filter(startsWithS).collect(toList());

		printWithTitle(sNames, "'S' names using a predicate");

		final List<String> bNames = friends.stream().filter(startsWithB).collect(toList());

		printWithTitle(bNames, "'B' names using a predicate");

		// Reusing a predicate method
		printWithTitle(friends.stream().filter(checkIfStartsWith("S")).collect(toList()),
				"'S' names using a common (but smelly) predicate");

		printWithTitle(friends.stream().filter(checkIfStartsWith("B")).collect(toList()),
				"'B' names using a common (but smelly) predicate");

		final Function<String, Predicate<String>> startsWithLetter = (String letter) -> {
			Predicate<String> checkStarts = (String name) -> name.startsWith(letter);
			return checkStarts;
		};

		printWithTitle(friends.stream().filter(startsWithLetter.apply("S")).collect(toList()),
				"Using startsWithLetter function");
		printWithTitle(friends.stream().filter(startsWithLetter.apply("B")).collect(toList()),
				"Using startsWithLetter function");

		final Function<String, Predicate<String>> betterStartsWithLetter = (
				String letter) -> (String name) -> name.startsWith(letter);

		printWithTitle(friends.stream().filter(betterStartsWithLetter.apply("S")).collect(toList()),
				"Using betterStartsWithLetter function");
		printWithTitle(friends.stream().filter(betterStartsWithLetter.apply("B")).collect(toList()),
				"Using betterStartsWithLetter function");
		
		final Function<String, Predicate<String>> bestStartsWithLetter = 
				letter -> name -> name.startsWith(letter);
				
		printWithTitle(friends.stream().filter(bestStartsWithLetter.apply("S")).collect(toList()),
				"Using bestStartsWithLetter function");
		printWithTitle(friends.stream().filter(bestStartsWithLetter.apply("B")).collect(toList()),
				"Using bestStartsWithLetter function");

	}

	public static Predicate<String> checkIfStartsWith(final String letter) {
		return name -> name.startsWith(letter);
	}

}
