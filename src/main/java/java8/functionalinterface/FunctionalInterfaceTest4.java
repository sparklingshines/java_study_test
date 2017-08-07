package java8.functionalinterface;

/**
 * 函数式接口中可以额外定义多个抽象方法，但这些抽象方法签名必须和Object的public方法一样
 * 
 * @author zhangbin
 *
 */
@FunctionalInterface
public interface FunctionalInterfaceTest4 {

	void count(int i);

	String toString(); // same to Object.toString

	int hashCode(); // same to Object.hashCode

	boolean equals(Object obj); // same to Object.equals
	
	/**
	 * clone()方法是protected  不能添加  添加将不能通过编译  会报错的
	 */
	//Object clone();

}
