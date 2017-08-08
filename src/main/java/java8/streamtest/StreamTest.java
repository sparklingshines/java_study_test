package java8.streamtest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

	public static void testLimitAndSkip() {
		List<Person> persons = new ArrayList<Person>();
		for (int i = 1; i <= 10000; i++) {
			Person person = new Person(i, "name" + i);
			persons.add(person);
		}
		List<String> personList2 = persons.stream().map(Person::getName).limit(10).skip(3).collect(Collectors.toList());
		System.out.println(personList2);
	}

	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		testLimitAndSkip();

		List<Person> persons = new ArrayList<Person>();
		for (int i = 1; i <= 5; i++) {
			Person person = new Person(i, "name" + i);
			persons.add(person);
		}

		List<Person> personList2 = persons.stream().sorted((p1, p2) -> p1.getName().compareTo(p2.getName())).limit(2)
				.collect(Collectors.toList());
		System.out.println(personList2);
		long endTime = System.currentTimeMillis();
		System.out.println((endTime - startTime) + "ms");

		List<Person> personList3 = persons.stream().limit(2).sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
				.collect(Collectors.toList());
		System.out.println(personList3);
		long endTime2 = System.currentTimeMillis();
		System.out.println((endTime2 - endTime) + "ms");

		BufferedReader br = new BufferedReader(
				new FileReader(new File("E:/java_study/java_study_test/src/main/java/java8/streamtest/test.txt")));
		int longest = br.lines().mapToInt(String::length).max().getAsInt();
		br.close();
		System.out.println(longest);

		BufferedReader br2 = new BufferedReader(
				new FileReader(new File("E:/java_study/java_study_test/src/main/java/java8/streamtest/test.txt")));
		List<String> words = br2.lines().flatMap(line -> Stream.of(line.split(" "))).filter(word -> word.length() > 0)
				.map(String::toLowerCase).distinct().sorted().collect(Collectors.toList());
		br2.close();
		System.out.println(words);

		Stream.of("one", "two", "three", "four").filter(e -> e.length() > 3)
				.peek(e -> System.out.println("Filtered value: " + e)).map(String::toUpperCase)
				.peek(e -> System.out.println("Mapped value: " + e)).collect(Collectors.toList());

		List<Person> personss = new ArrayList<Person>();
		personss.add(new Person(1, "name" + 1, 10));
		personss.add(new Person(2, "name" + 2, 21));
		personss.add(new Person(3, "name" + 3, 34));
		personss.add(new Person(4, "name" + 4, 6));
		personss.add(new Person(5, "name" + 5, 55));
		boolean isAllAdult = personss.stream().allMatch(p -> p.getAge() > 18);
		System.out.println("All are adult? " + isAllAdult);
		boolean isThereAnyChild = personss.stream().anyMatch(p -> p.getAge() < 12);
		System.out.println("Any child? " + isThereAnyChild);
		boolean isNoneMatch = personss.stream().noneMatch(p -> p.getAge() > 56);
		System.out.println("none child? " + isNoneMatch);

		System.out.println("random:");
		Random seed = new Random();
		Supplier<Integer> random = seed::nextInt;
		Stream.generate(random).limit(10).forEach(System.out::println);
		System.out.println("========");
		IntStream.generate(() -> (int) (System.nanoTime() % 100)).limit(10).forEach(System.out::println);
		System.out.println("random:");

		System.out.println("PersonSupplier implements Supplier:");
		Stream.generate(new PersonSupplier()).limit(10)
				.forEach(p -> System.out.println(p.getName() + ", " + p.getAge()));

		Stream.iterate(0, n -> n + 3).limit(10).forEach(x -> {
			System.out.print(x + "\t");
		});
		System.out.println();

		Map<Integer, List<Person>> personGroups = Stream.generate(new PersonSupplier()).limit(100)
				.collect(Collectors.groupingBy(Person::getAge));
		Iterator<Entry<Integer, List<Person>>> it = personGroups.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Integer, List<Person>> personBean = (Map.Entry<Integer, List<Person>>) it.next();
			System.out.println("Age " + personBean.getKey() + " = " + personBean.getValue().size());
		}

		Map<Boolean, List<Person>> children = Stream.generate(new PersonSupplier()).limit(100)
				.collect(Collectors.partitioningBy(p -> p.getAge() < 18));
		System.out.println("Children number: " + children.get(true).size());
		System.out.println("Adult number: " + children.get(false).size());

	}

}
