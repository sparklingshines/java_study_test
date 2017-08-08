package java8.streamtest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamLimitOrSkipOrSortTest {

	public static void testLimitAndSkip() {
		List<Person> persons = new ArrayList<Person>();
		for (int i = 1; i <= 10000; i++) {
			Person person = new Person(i, "name" + i);
			persons.add(person);
		}
		List<String> personList2 = persons.stream().map(Person::getName).limit(10).skip(3).collect(Collectors.toList());
		personList2.forEach(System.out::println);
	}

	public static void main(String[] args) {
		testLimitAndSkip();
		System.out.println("---------------------------------------");

		long startTime = System.currentTimeMillis();
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
		System.out.println("---------------------------------------");

		List<Person> personList3 = persons.stream().limit(2).sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
				.collect(Collectors.toList());
		System.out.println(personList3);
		long endTime2 = System.currentTimeMillis();
		System.out.println((endTime2 - endTime) + "ms");
		System.out.println("---------------------------------------");
	}

}
