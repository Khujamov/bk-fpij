package us.cyzic.fpij.designing;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class AssetUtil {

	final static List<Asset> assets = Arrays.asList(
			new Asset(Asset.AssetType.BOND, 1000),
			new Asset(Asset.AssetType.BOND, 2000),
			new Asset(Asset.AssetType.STOCK, 3000),
			new Asset(Asset.AssetType.STOCK, 4000));
	
	public static void main(String[] args) {
		System.out.println("Total value of all assets: " + totalAssetValues(assets));
		System.out.println("Average value of assets: " + averageAssetValue(assets));

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

}
