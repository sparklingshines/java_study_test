package java8.streamtest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamStructureTest {

	public static void main(String[] args) {
		Stream<String> stream1 = Stream.of("a", "b", "c");
		stream1.forEach(System.out::println);
		System.out.println("-------------------------------");
		String[] strArray = new String[] { "A", "B", "C" };
		Stream<String> stream2 = Stream.of(strArray);
		stream2.forEach(System.out::println);
		System.out.println("-------------------------------");
		Stream<String> stream3 = Arrays.stream(strArray);
		stream3.forEach(System.out::println);
		System.out.println("-------------------------------");
		// 3. Collections
		List<String> list = Arrays.asList(strArray);
		Stream<String> stream4 = list.stream();
		stream4.forEach(System.out::println);
		System.out.println("-------------------------------");

		IntStream.of(new int[] { 1, 2, 3 }).forEach(System.out::println);
		System.out.println("-------------------------------");
		IntStream.range(1, 3).forEach(System.out::println);
		System.out.println("-------------------------------");
		IntStream.rangeClosed(1, 3).forEach(System.out::println);
	}

}
