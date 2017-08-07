package java8.functionalinterface;

@FunctionalInterface
public interface FunctionalInterfaceTest2 {

	public void run();

	default void doSomeMoreWork1() {
		System.out.println("doSomeMoreWork1");
	}

	default void doSomeMoreWork2() {
		System.out.println("doSomeMoreWork2");
	}

}
