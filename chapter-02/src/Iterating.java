import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Iterating {

	final static List<String> friends = 
			Arrays.asList("Brian", "Nate", "Raju", "Sara", "Scott");
	
	public static void main(String[] args) {
		
		// Slightly more civilized than old iterator
		for(String name : friends) {
			System.out.println(name);
		}
		
		// Functional but with anonymous inner class syntax
		friends.forEach(new Consumer<String>() {
			public void accept(final String name) {
				System.out.println(name);
			}
		});
		
		// Functional but with using lambdas
		System.out.println("");
		System.out.println("Functional but with using lambdas");
		friends.forEach((final String name) -> System.out.println(name));;
		
		// Functional without the unnecessary declaration
		System.out.println("");
		System.out.println("Functional without the unnecessary declaration");
		friends.forEach(name -> System.out.println(name));
		
		// Functional using method reference
		System.out.println("");
		System.out.println("Functional using method reference");
		friends.forEach(System.out::println);
	}

}
