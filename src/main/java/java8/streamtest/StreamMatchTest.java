package java8.streamtest;

import java.util.ArrayList;
import java.util.List;

public class StreamMatchTest {

	public static void main(String[] args) {
		List<Person> personss = new ArrayList<Person>();
		personss.add(new Person(1, "name" + 1, 10));
		personss.add(new Person(2, "name" + 2, 21));
		personss.add(new Person(3, "name" + 3, 34));
		personss.add(new Person(4, "name" + 4, 6));
		personss.add(new Person(5, "name" + 5, 55));
		boolean isAllAdult = personss.stream().allMatch(p -> p.getAge() > 18);
		System.out.println("All are adult? " + isAllAdult);
		System.out.println("---------------------");
		boolean isThereAnyChild = personss.stream().anyMatch(p -> p.getAge() < 12);
		System.out.println("Any child? " + isThereAnyChild);
		System.out.println("---------------------");
		boolean isNoneMatch = personss.stream().noneMatch(p -> p.getAge() > 56);
		System.out.println("none child? " + isNoneMatch);
	}

}
