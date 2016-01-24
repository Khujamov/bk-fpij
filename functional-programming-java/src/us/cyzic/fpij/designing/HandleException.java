package us.cyzic.fpij.designing;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

public class HandleException {

	public static void main(String[] args) throws IOException {
		
		// this code won't compile because of unhandled IOException!
//		Stream.of("usr", "tmp")
//			.map(path -> new File(path).getCanonicalPath())
//			.forEach(System.out::println);
	
		// This works, but is ugly...will revisit this later
		Stream.of("/usr", "tmp")
			.map(path -> {
				try {
					return new File(path).getCanonicalPath();
				} catch (IOException ex) {
					return ex.getMessage();
				}
			})
			.forEach(System.out::println);

	}

}
