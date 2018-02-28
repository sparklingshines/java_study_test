package java8.comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import java8.comparator.Person;

public class ComparatorTest {

	public static void main(String[] args) {
		List<Person> humans = new ArrayList<Person>();
		humans.add(new Person("Sarah", 9, "ZHEJIANG HANGZHOU"));
		humans.add(new Person("Jack", 12, "ZHEJIANG HANGZHOU"));
		humans.add(new Person("Waha", 10, "ZHEJIANG HANGZHOU"));
		
		// 匿名方式排序
		Collections.sort(humans, new Comparator<Person>() {
			@Override
			public int compare(Person h1, Person h2) {
				return h1.getName().compareTo(h2.getName());
			}
		});
		System.out.println(Arrays.toString(humans.toArray()));
		// 排序1
		humans.sort((h1, h2) -> h1.getName().compareTo(h2.getName()));
		// 排序1
		Collections.sort(humans, Comparator.comparing(Person::getAge));
		System.out.println(Arrays.toString(humans.toArray()));
		// 反转排序
		Comparator<Person> comparator = (h1, h2) -> h1.getName().compareTo(h2.getName());
	    humans.sort(comparator.reversed());
	    // 多条件排序
	    humans.sort(Comparator.comparing(Person::getName).thenComparing(Person::getAge));
		System.out.println(Arrays.toString(humans.toArray()));
	}

}
