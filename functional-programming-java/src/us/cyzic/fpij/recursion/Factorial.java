package us.cyzic.fpij.recursion;

public class Factorial {

	public static int factorialRec(final int number) {
		if(number == 1) 
			return number;
		else
			return number * factorialRec(number - 1);
	}
	
	public static TailCall<Integer> factorialTailRec(final int factorial, final int number) {
		if(number == 1) {
			return TailCalls.done(factorial);
		}
		else {
			return TailCalls.call(() -> factorialTailRec(factorial * number, number - 1));
		}
	}
	
	public static void main(String[] args) {
		
		
		// Unoptimized...will throw stack overflow with large number
		System.out.println("Unoptimized recursion of 5: " + factorialRec(5));
		
		try {
			System.out.println("Unoptimized recursion of 20000: " + factorialRec(20000));
		} catch (StackOverflowError ex) {
			System.out.println(ex);
		}
		
		System.out.println("Optimized recursion of 5: " + factorialTailRec(1, 5).invoke());
		System.out.println("Optimized recursion of 20: " + factorialTailRec(1, 20).invoke());
		
	}

}
