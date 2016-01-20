package us.cyzic.fpij.compare;

import java.util.StringJoiner;

public class IterateString {

	public static void main(String[] args) {
		final String word = "w00t";
		
		System.out.println("Printing each character (as int):");
		word.chars().forEach(ch -> System.out.println(ch));

		System.out.println("");
		System.out.println("Printing each character cast to char:");
		word.chars().forEach(ch -> System.out.println((char)ch));
		
		System.out.println();
		System.out.println("Converting into chars and then printing each:");
		word.chars()
			.mapToObj(ch -> Character.valueOf((char)ch))
			.forEach(System.out::println);
				
		System.out.println();
		System.out.println("Filtering out non-integers:");
		word.chars()
			.filter(ch -> Character.isDigit(ch))
			.forEach(ch -> printChar(ch));
		
		System.out.println();
		System.out.println("Filtering out integers using method reference:");
		word.chars()
			.filter(Character::isAlphabetic)
			.forEach(IterateString::printChar);
		
	}

	private static void printChar(int aChar) {
		System.out.println((char) aChar);
	}
	
}
