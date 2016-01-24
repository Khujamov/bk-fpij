package us.cyzic.fpij.designing;

public class CalculateNavUtil {

	public static void main(String[] args) {
		final CalculateNAV calculateNav = new CalculateNAV(YahooFinance::getPrice);
		System.out.println(String.format("100 shares of Google worth: $%.2f", calculateNav.computeStockWorth("GOOG", 100)));
	}
	
}
