package java8.streamtest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMapTest {

	public static void main(String[] args) {
		String[] str = new String[] { "test", "file", "map", "reduce", "mapreduce" };
		List<String> wordList = Arrays.asList(str);
		wordList.stream().map(String::toUpperCase).collect(Collectors.toList())
				.forEach((element) -> System.out.println(element));
		System.out.println("---------------------------");
		wordList.stream().map(String::toUpperCase).collect(Collectors.toList()).forEach(System.out::println);
		System.out.println("---------------------------");
		List<Integer> nums = Arrays.asList(1, 2, 3, 4);
		List<Integer> squareNums = nums.stream().map(n -> n * n).collect(Collectors.toList());
		squareNums.forEach(System.out::println);
		System.out.println("---------------------------");
		Stream<List<Integer>> inputStream = Stream.of(Arrays.asList(1), Arrays.asList(2, 3), Arrays.asList(4, 5, 6));
		Stream<Integer> outputStream = inputStream.flatMap((childList) -> childList.stream());
		outputStream.forEach(System.out::println);
		System.out.println("---------------------------");

	}

}
