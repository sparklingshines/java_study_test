package java8.streamtest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFilterTest {

	public static void main(String[] args) throws IOException {
		Integer[] sixNums = { 1, 2, 3, 4, 5, 6 };
		Integer[] evens = Stream.of(sixNums).filter(n -> n % 2 == 0).toArray(Integer[]::new);
		System.out.println(Arrays.toString(evens));
		System.out.println("------------------------");

		BufferedReader reader = new BufferedReader(
				new FileReader(new File("E:/java_study/java_study_test/src/main/java/java8/streamtest/test.txt")));
		List<String> output = reader.lines().flatMap(line -> Stream.of(line.split(" ")))
				.filter(word -> word.length() > 0).collect(Collectors.toList());
		output.forEach(System.out::println);
		reader.close();
		System.out.println("------------------------");
		
	}

}
