package us.cyzic.fpij.compare;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListSubDirs {

	public static void main(String[] args) {
		listTheHardWay();
		listTheBetterWay();
	}
	
	public static void listTheBetterWay() {
		List<File> files =
				Stream.of(new File(".").listFiles())
					.flatMap(file -> file.listFiles() == null ?
							Stream.of(file) : Stream.of(file.listFiles()))
					.collect(Collectors.toList());
		
		printFileInformation(files);
	}
	
	public static void listTheHardWay() {
		List<File> files = new ArrayList<>();
		
		File[] filesInCurrentDir = new File(".").listFiles();
		for(File file : filesInCurrentDir) {
			File[] filesInSubDir = file.listFiles();
			if(filesInSubDir != null) {
				files.addAll(Arrays.asList(filesInSubDir));
			} else {
				files.add(file);
			}
		}
		
		printFileInformation(files);
	}

	private static void printFileInformation(List<File> files) {
		System.out.println("Count: " + files.size());
		for(File file : files) {
			System.out.println(file.getAbsolutePath());
		}
		System.out.println();
	}

}
