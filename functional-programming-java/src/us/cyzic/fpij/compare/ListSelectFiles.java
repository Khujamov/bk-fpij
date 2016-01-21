package us.cyzic.fpij.compare;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class ListSelectFiles {

	public static void main(String[] args) throws IOException {
		
		final String[] filesWithList =
				new File("./src/us/cyzic/fpij/compare").list(new java.io.FilenameFilter() {
					public boolean accept(final File dir, final String name) {
						return name.contains("List");
					}
				});
		System.out.println("Files with 'List': " + Arrays.asList(filesWithList));
		System.out.println();
		
		Files.newDirectoryStream(
				Paths.get("./src/us/cyzic/fpij/compare"), 
					path -> path.toString().contains("List"))
				.forEach(System.out::println);
		
		System.out.println();
		
		final File[] visibleFiles = new File(".").listFiles(file -> !file.isHidden());
		System.out.println("Visible files: " + Arrays.asList(visibleFiles));
		System.out.println();
		
		final File[] hiddenFiles = new File(".").listFiles(File::isHidden);
		System.out.println("Hidden files: " + Arrays.asList(hiddenFiles));
	}

}
