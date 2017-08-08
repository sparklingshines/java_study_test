package java8.streamtest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMinOrMaxOrDistinctTest {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new FileReader(new File("E:/java_study/java_study_test/src/main/java/java8/streamtest/test.txt")));
		int longest = br.lines().mapToInt(String::length).max().getAsInt();
		br.close();
		System.out.println(longest);
		System.out.println("-------------------------------");

		BufferedReader br2 = new BufferedReader(
				new FileReader(new File("E:/java_study/java_study_test/src/main/java/java8/streamtest/test.txt")));
		List<String> words = br2.lines().flatMap(line -> Stream.of(line.split(" "))).filter(word -> word.length() > 0)
				.map(String::toLowerCase).distinct().sorted().collect(Collectors.toList());
		br2.close();
		System.out.println(words);
		System.out.println("-------------------------------");
	}

}
	