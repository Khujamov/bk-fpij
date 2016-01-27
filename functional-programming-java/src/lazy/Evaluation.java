package lazy;

import java.util.function.Supplier;

public class Evaluation {
	
	public static boolean evaluate(final int value) {
		System.out.println("evaluating ..." + value);
		simulateTimeConsumingOp(2000);
		return value > 100;
	}

	private static void simulateTimeConsumingOp(long i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void eagerEvaluator(final boolean input1, final boolean input2) {
		System.out.println("eagerEvaluator called...");
		System.out.println("accept?: " + (input1 && input2));
	}
	
	public static void lazyEvaluator(final Supplier<Boolean> input1, final Supplier<Boolean> input2) {
		System.out.println("lazyEvaluator called...");
		System.out.println("accept?: " + (input1.get() && input2.get()));
	}

	public static void main(String[] args) {
		System.out.println("Eager evaluation (evaluates both values regardless)");
		eagerEvaluator(evaluate(1), evaluate(2));
		System.out.println();
		System.out.println("Lazy evaluation (only evaluates second value if necessary)");
		lazyEvaluator(() -> evaluate(1), () -> evaluate(2));
	}

}
