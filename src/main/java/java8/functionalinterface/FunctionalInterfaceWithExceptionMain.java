package java8.functionalinterface;

public class FunctionalInterfaceWithExceptionMain {

	public static void main(String[] args) {
		FunctionalInterfaceWithException target = i -> {
			System.out.println(i);
		};
		try {
			target.apply(10);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
