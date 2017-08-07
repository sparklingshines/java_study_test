package java8.functionalinterface;

/**
 * 函数式接口的抽象方法可以声明 可检查异常(checked exception)。 在调用目标对象的这个方法时必须catch这个异常。
 * 
 * @author zhangbin
 *
 */
@FunctionalInterface
public interface FunctionalInterfaceWithException {

	void apply(int i) throws Exception;

}
