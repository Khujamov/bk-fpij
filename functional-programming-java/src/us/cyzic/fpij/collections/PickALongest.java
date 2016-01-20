package us.cyzic.fpij.collections;

import static us.cyzic.fpij.collections.TransformList.*;

import java.util.List;
import java.util.Optional;

public class PickALongest {

	public static void main(String[] args) {
		final List<String> friends = TransformList.friends;
		
		printSumOfAllCharacters(friends);
		System.out.println("");
		
		printTheLongestName(friends);
	}
	
	public static void printSumOfAllCharacters(List<String> names) {
		System.out.println("The total number of characters in all names: " +
			friends.stream()
					.mapToInt(name -> name.length())
					.sum()
		);
	}
	
	public static void printTheLongestName(List<String> names) {
		Optional<String> aLongName =
				names.stream()
					.reduce((name1, name2) -> name1.length() >= name2.length() ? name1 : name2);
		aLongName.ifPresent(name -> System.out.println(String.format("A longest name: %s", name)));
	}

}
