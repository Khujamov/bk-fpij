package us.cyzic.fpij.collections;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TransformList {

	final static List<String> friends = 
			Arrays.asList("Brian", "Nate", "Raju", "Sara", "Scott", "Freddy");
	
	public static void printWithTitle(List<String> list, String title) {
		System.out.println(title + "...");
		list.stream().forEach(System.out::println);
		System.out.println("");
	}
	
	public static void printIntsWithTitle(List<Integer> list, String title) {
		final List<String> stringList =
				list.stream().map(item -> item.toString())
				.collect(Collectors.toList());
		printWithTitle(stringList, title);
	}
	
	public static void main(String[] args) {
		
		// Use map to create a new list
		final List<String> upperNames = friends.stream()
				.map(name -> name.toUpperCase())
				.collect(Collectors.toList());
		
		printWithTitle(upperNames, "Use map to create a new list");
		
		// Now using method reference
		final List<String> lowerNames = friends.stream()
				.map(String::toLowerCase)
				.collect(Collectors.toList());

		printWithTitle(lowerNames, "Now using method reference");
		
		// Use filter to create a subset of names
		final List<String> namesStartingWithN =
				friends.stream()
						.filter(name -> name.startsWith("N"))
						.collect(Collectors.toList());
		
		printWithTitle(namesStartingWithN, "Use filter to create a subset");
		
		// Combining a filter and a map
		final List<String> namesStartingWithS = 
				friends.stream()
					.filter(name -> name.startsWith("S"))
					.map(String::toUpperCase)
					.collect(Collectors.toList());
		
		printWithTitle(namesStartingWithS, "Combining a filter and a map");
		
		// Filtering and mapping to a new list type
		final List<Integer> longerNames =
				friends.stream()
					.filter(item -> item.length() > 4)
					.map(item -> item.length())
					.collect(Collectors.toList());
		
		printIntsWithTitle(longerNames, "Filtering and mapping to a new list type");
	}

}
