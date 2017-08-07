package java8.lambdaexpression;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class LambdaTest {

	public static void main(String[] args) {
		Arrays.asList("a", "b", "d").forEach(e -> System.out.print(e + "\t"));
		System.out.println();
		Arrays.asList("a", "b", "d").forEach((String e) -> System.out.print(e + "\t"));
		System.out.println();
		String separator = ",";
		Arrays.asList("a", "b", "d").forEach((String e) -> System.out.print(e + separator));
		Arrays.asList("a", "e", "g", "s", "hg", "b", "d").sort((e1, e2) -> e1.compareTo(e2));

		ExecutorService executorService = Executors.newFixedThreadPool(10);
		IntStream.range(0, 5).forEach(i -> executorService.submit(new Runnable() {
			public void run() {
				System.out.println("Running task " + i);
			}
		}));

		executorService.shutdown();
		
		ExecutorService executorService2 = Executors.newFixedThreadPool(10);
		IntStream.range(0, 5).forEach(i -> executorService2.submit(() -> System.out.println("Running task " + i)));
		executorService2.shutdown();
	}

}
