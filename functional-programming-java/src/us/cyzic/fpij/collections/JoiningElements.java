package us.cyzic.fpij.collections;

import static us.cyzic.fpij.collections.TransformList.*;

import java.util.List;
import java.util.stream.Collectors;

public class JoiningElements {

	public static void main(String[] args) {
		final List<String> friends = TransformList.friends;

		System.out.println("Using the String.join() - StringJoiner class");
		System.out.println(String.join(", ", friends));
		
		
		System.out.println("");
		System.out.println("Using collect(joining...) - which is another form of reduce");
		System.out.println("that can help us collect values into a target destination");
		
		System.out.println(
				friends.stream()
					.map(String::toUpperCase)
					.collect(Collectors.joining(", ")));
		
	}

}
