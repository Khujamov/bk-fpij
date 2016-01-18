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
		friends.forEach((final String name) -> System.out.println(name));;
	}

}
