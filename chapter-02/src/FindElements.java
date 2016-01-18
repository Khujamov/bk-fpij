import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FindElements {

	final static List<String> friends = 
			Arrays.asList("Brian", "Nate", "Raju", "Sara", "Scott", "Betty");
	
	public static void main(String[] args) {
		
		// A simple filter
		final List<String> sAndBNames = 
				friends.stream()
					.filter(item -> item.startsWith("B") || item.startsWith("S"))
					.collect(Collectors.toList());
		
		TransformList.printWithTitle(sAndBNames, "A simple filter");
		
		// Using a predicate
		final Predicate<String> startsWithS = name -> name.startsWith("S");
		
		final List<String> sNames = 
				friends.stream()
					.filter(startsWithS)
					.collect(Collectors.toList());
		
		TransformList.printWithTitle(sNames, "Using a predicate");
		
		
		
	}

}
