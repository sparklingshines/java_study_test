package java8.functionalinterface;

/**
 * Java 8中允许接口实现方法， 而不是简单的声明， 这些方法叫做默认方法，使用特殊的关键字default。
 * 因为默认方法不是抽象方法，所以不影响我们判断一个接口是否是函数式接口。
 * 
 * @author zhangbin
 * @date 2017年8月7日 下午8:57:38
 */
@FunctionalInterface
public interface FunctionalInterfaceWithWithDefaultMethod {

	void apply(Object obj);

	default void say(String name) {
		System.out.println("this is from the functionalInterface default methond!");
		System.out.println("hello " + name);
	}

}
