package recursion;

public class Factorial {

	public static int factorialRec(final int number) {
		if(number == 1) 
			return number;
		else
			return number * factorialRec(number - 1);
	}
	
	public static void main(String[] args) {
		
		// Unoptimized...will throw stack overflow with large number
		System.out.println("Unoptimized recursion of 5: " + factorialRec(5));
		
		try {
			System.out.println("Unoptimized recursion of 20000: " + factorialRec(20000));
		} catch (StackOverflowError ex) {
			System.out.println(ex);
		}

	}

}
