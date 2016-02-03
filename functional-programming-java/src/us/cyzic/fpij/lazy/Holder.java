package us.cyzic.fpij.lazy;

import java.util.function.Supplier;

public class Holder {

	private Supplier<Heavy> heavy = () -> createAndCacheHeavy();

	public static void main(String[] args) {
		final Holder holder = new Holder();
		System.out.println("deferring heavy creation...");
		System.out.println(holder.getHeavy());
		System.out.println(holder.getHeavy());
	}

	private synchronized Heavy createAndCacheHeavy() {
		class HeavyFactory implements Supplier<Heavy> {
			private final Heavy heavyInstance = new Heavy();

			@Override
			public Heavy get() {
				return heavyInstance;
			}
		}

		if (!HeavyFactory.class.isInstance(heavy)) {
			heavy = new HeavyFactory();
		}

		return heavy.get();
	}
	
	public Heavy getHeavy() {
		return heavy.get();
	}

}
