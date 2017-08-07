package java8.functionalinterface;

/**
 * 如果在Lambda表达式中抛出异常， 而目标接口中的抽象函数没有声明这个可检查， 则此接口不能作为此lambda表达式的目标类型。
 * @author zhangbin
 *
 */
public class FunctionalInterfaceWithoutExceptionMain {

	public static void main(String[] args) {
		//InterfaceWithoutException target = i -> {throw new Exception();};  将不能通过编译
	}

}
