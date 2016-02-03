package us.cyzic.fpij.recursion;

import java.util.Arrays;
import java.util.List;

public class RodCutterBasic {

	final List<Integer> prices;
	
	public RodCutterBasic(final List<Integer> pricesForLength) {
		prices = pricesForLength;
	}
	
	public int maxProfit(final int length) {
		int profit = (length <= prices.size()) ? prices.get(length - 1) : 0;
		for (int i = 1; i < length; i++) {
			int priceWhenCut = maxProfit(i) + maxProfit(length - i);
			if(profit < priceWhenCut) profit = priceWhenCut;
		}
		return profit;
	}
	
	public static void main(String[] args) {
		final List<Integer> priceValues = Arrays.asList(2, 1, 1, 2, 2, 2, 1, 8, 9, 15);
		final RodCutterBasic rodCutter = new RodCutterBasic(priceValues);
		System.out.println(rodCutter.maxProfit(5));
		System.out.println(rodCutter.maxProfit(22));
	}

}
