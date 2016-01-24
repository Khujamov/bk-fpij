package us.cyzic.fpij.designing;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Predicate;

public class AssetUtil {

	final static List<Asset> assets = Arrays.asList(
			new Asset(Asset.AssetType.BOND, 1000),
			new Asset(Asset.AssetType.BOND, 2000),
			new Asset(Asset.AssetType.STOCK, 3000),
			new Asset(Asset.AssetType.STOCK, 4000));
	
	final static Predicate<Asset> stocks = asset -> asset.getType() == Asset.AssetType.STOCK;
	final static Predicate<Asset> bonds = asset -> asset.getType() == Asset.AssetType.BOND;
	
	public static void main(String[] args) {
		System.out.println("Total value of all assets: " + totalAssetValues(assets));
		System.out.println("Average value of assets: " + averageAssetValue(assets));
		System.out.println("Total of bonds: " + totalBondValues(assets));
		System.out.println("Total of stocks: " + totalStockValues(assets));
		System.out.println("Total of bonds (using inline predicate): " + 
				totalAssetValues(assets, asset -> asset.getType() == Asset.AssetType.BOND));
		System.out.println("Total of stocks (using inline predicate): " +
				totalAssetValues(assets, asset -> asset.getType() == Asset.AssetType.STOCK));
		System.out.println("Total of bonds (using stored predicate): " + totalAssetValues(assets, bonds));
		System.out.println("Total of stocks (using stored predicate): " + totalAssetValues(assets, stocks));
	}
	
	public static int totalAssetValues(final List<Asset> assets) {
		return assets.stream()
				.mapToInt(Asset::getValue)
				.sum();
	}
	
	public static double averageAssetValue(final List<Asset> assets) {
		OptionalDouble averageValue = assets.stream()
				.mapToDouble(Asset::getValue)
				.average();
		
		return averageValue.isPresent() ? averageValue.getAsDouble() : 0;
	}

	public static int totalBondValues(final List<Asset> assets) {
		return assets.stream()
				.mapToInt(asset -> asset.getType() == Asset.AssetType.BOND 
					? asset.getValue() : 0)
				.sum();
	}
	
	public static int totalStockValues(final List<Asset> assets) {
		return assets.stream()
				.mapToInt(asset -> asset.getType() == Asset.AssetType.STOCK 
					? asset.getValue() : 0)
				.sum();
	}
	
	public static int totalAssetValues(final List<Asset> assets, 
			final Predicate<Asset> assetSelector) {
		return assets.stream()
				.filter(assetSelector)
				.mapToInt(Asset::getValue)
				.sum();
	}
	
}
