import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import us.cyzic.fpij.collections.TransformList;

import static java.util.stream.Collectors.*;
import static us.cyzic.fpij.collections.TransformList.*;

public class FindElements {

	final static List<String> friends = 
			Arrays.asList("Brian", "Nate", "Raju", "Sara", "Scott", "Betty");
	
	public static void main(String[] args) {
		
		// A simple filter
		final List<String> sAndBNames = 
				friends.stream()
					.filter(item -> item.startsWith("B") || item.startsWith("S"))
					.collect(Collectors.toList());
		
		printWithTitle(sAndBNames, "A simple filter");
		
		// Using a predicate
		final Predicate<String> startsWithS = name -> name.startsWith("S");
		final Predicate<String> startsWithB = name -> name.startsWith("B");
		
		final List<String> sNames = 
				friends.stream()
					.filter(startsWithS)
					.collect(toList());
		
		printWithTitle(sNames, "'S' names using a predicate");
		
		final List<String> bNames =
				friends.stream()
					.filter(startsWithB)
					.collect(toList());
		
		printWithTitle(bNames, "'B' names using a predicate");
	}

}
