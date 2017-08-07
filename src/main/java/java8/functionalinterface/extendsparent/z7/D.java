package java8.functionalinterface.extendsparent.z7;

/**
 * 接口可以继承接口。 如果父接口是一个函数接口， 那么子接口也可能是一个函数式接口。 判断标准依据下面的条件： 对于接口I,
 * 假定M是接口成员里的所有抽象方法的继承(包括继承于父接口的方法)， 除去具有和Object的public的实例方法签名的方法，
 * 那么我们可以依据下面的条件判断一个接口是否是函数式接口， 这样可以更精确的定义函数式接口。 如果存在一个一个方法m， 满足：
 * 
 * m的签名（subsignature）是M中每一个方法签名的子签名（signature）
 * m的返回值类型是M中的每一个方法的返回值类型的替代类型（return-type-substitutable） 那么I就是一个函数式接口。
 * 
 * @author zhangbin
 * @date 2017年8月7日 下午9:06:54
 */
public interface D extends A, B {
	// D has function type (List)->List throws EOFException,SQLTransientException
}
