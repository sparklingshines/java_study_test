package java8.lambdaexpression;

import java.util.function.Function;

public class FunctionTest {

    public static void testFunction() {
        //简单的,只有一行
        Function<Integer, String> function1 = (x) -> "test result: " + x;

        //标准的,有花括号, return, 分号.
        Function<String, String> function2 = (x) -> {
            return "after function1";
        };
        System.out.println(function1.apply(6));
        System.out.println(function1.andThen(function2).apply(5));
        System.out.println(function1.andThen(function2).apply(6));
    }


    public static void main(String[] args) {
        testFunction();
    }

}
