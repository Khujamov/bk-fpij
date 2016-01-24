package us.cyzic.fpij.designing;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class CalculateNAVTest {

	@Test
	public void computeStockWorth() {
		final CalculateNAV calculateNAV =
				new CalculateNAV(ticker -> new BigDecimal("6.01"));
		BigDecimal expected = new BigDecimal("6010.00");
		assertEquals(0, calculateNAV.computeStockWorth("GOOG", 1000).compareTo(expected), 0.001);
		System.out.println("100 shares of Google worth (mocked data): " + calculateNAV.computeStockWorth("GOOG", 100));
	}
}
