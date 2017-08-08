package java8.streamtest;

import java.util.Optional;

public class StreamFineFirstTest {

	public static void print(String text) {
		Optional.ofNullable(text).ifPresent(System.out::println);
		if (text != null) {
			System.out.println(text);
		}
	}

	public static int getLength(String text) {
		return Optional.ofNullable(text).map(String::length).orElse(-1);
	};

	public static void main(String[] args) {
		String strA = " abcd ", strB = null;

		print(strA);
		System.out.println(getLength(strA));
		System.out.println(getLength(""));
		System.out.println("---------------------------------");
		print(strB);
		System.out.println(getLength(strB));
		System.out.println(getLength(""));
	}

}
