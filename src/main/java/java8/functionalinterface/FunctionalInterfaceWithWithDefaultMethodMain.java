package java8.functionalinterface;

/**
 * 
 * @author zhangbin
 * @date 2017年8月7日 下午8:55:40
 */
public class FunctionalInterfaceWithWithDefaultMethodMain {

	public static void main(String[] args) {
		FunctionalInterfaceWithWithDefaultMethod target = (name) -> {
		};
		target.apply(null);
		target.say("default method");
		
		FunctionalInterfaceWithWithDefaultMethod i = (str) ->{System.out.println("hello from "+ str);};
		i.apply("main methond");
		i.say("word!");

	}

}
