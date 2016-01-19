package us.cyzic.fpij.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static us.cyzic.fpij.collections.TransformList.*;

public class PickAnElement {

	public static void main(String[] args) {
		
		final List<String> friends = TransformList.friends;
		pickNameOld(friends, "N");
		pickNameOld(friends, "Z");
		pickNameOld(friends, "S");
		
		System.out.println("");
		
		pickNameElegant(friends, "B");
		pickNameElegant(friends, "S");
		pickNameElegant(friends, "C");
	}
	
	// So friggin' fugly it's ridiculous to think anyone would write it
	private static void pickNameOld(final List<String> names, final String startingLetter) {
		String foundName = null;
		for(String name : names) {
			if(name.startsWith(startingLetter)) {
				foundName = name;
				break;
			}
		}
		
		System.out.print(String.format("(Old Way) A name starting with %s: ", startingLetter));
		if(foundName != null) {
			System.out.println(foundName);
		} else {
			System.out.println("No name found");
		}
	}
	
	private static void pickNameElegant(final List<String> names, final String letter) {
		final Optional<String> foundName =
				names.stream()
					.filter(name -> name.startsWith(letter))
					.findFirst();
		
		System.out.println(String.format("(New Way) A name starting with %s: %s", 
				letter, foundName.orElse("No name found")));
		
	}
	
	

}
