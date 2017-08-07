package java8.functionalinterface;

public class FunctionalInterfaceWithStaticMethodMain {

	public static void main(String[] args) {
		int sum = FunctionalInterfaceWithStaticMethod.sum(new int[] { 1, 2, 3, 4, 5 });
		System.out.println(sum);
		FunctionalInterfaceWithStaticMethod f = () -> {
			System.out.println("这是一个没有参数的函数式接口。");
		};
		f.apply();
	}

}
