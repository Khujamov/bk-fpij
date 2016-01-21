package us.cyzic.fpij.compare;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ListFiles {

	public static void main(String[] args) throws IOException {
		
		System.out.println("All files and subdirectories:");
		Files.list(Paths.get("./src/us/cyzic/fpij/compare"))
			.forEach(System.out::println);
		System.out.println();
		
		
		// Can filter out files...only list subdirectories
		System.out.println("Only subdirectories:");
		Files.list(Paths.get("../."))
			.filter(Files::isDirectory)
			.forEach(System.out::println);
		System.out.println();
	}

}
