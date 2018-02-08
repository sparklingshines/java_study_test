package java8.optional;

import java.util.Optional;

class ValueAbsentException extends Throwable {

    public ValueAbsentException() {
        super();
    }

    public ValueAbsentException(String msg) {
        super(msg);
    }

    @Override
    public String getMessage() {
        return "No value present in the Optional instance";
    }
}

public class OptionalTest {

    public static void main(String[] args) {
        // 调用工厂方法创建Optional实例
        Optional<String> name = Optional.of("Sanaulla");
        // 传入参数为null，抛出NullPointerException.
        //Optional<String> someNull = Optional.of(null);

        // 下面创建了一个不包含任何值的Optional实例
        // 例如，值为'null'
        Optional empty = Optional.ofNullable(null);
        System.out.println(empty.isPresent());

        if (name.isPresent()){
            System.out.println(name.get());
        }

        // ifPresent方法接受lambda表达式作为参数。
        // lambda表达式对Optional的值调用consumer进行处理。
        name.ifPresent((value) -> {
            System.out.println("The length of the value is: " + value.length());
        });

        // 如果值不为null，orElse方法返回Optional实例的值,如果为null，返回传入的消息。
        System.out.println(empty.orElse("There is no value present!"));
        // 输出：Sanaulla
        System.out.println(name.orElse("There is some value!"));

        //orElseGet与orElse方法类似，区别在于orElse传入的是默认值，orElseGet可以接受一个lambda表达式生成默认值。
        //输出：Default Value
        System.out.println(empty.orElseGet(() -> "Default Value"));
        // 输出null，Supplier没有对null进行处理
        System.out.println(empty.orElseGet(() -> null));
        //输出：Sanaulla
        System.out.println(name.orElseGet(() -> "Default Value"));

        try {
            // orElseThrow与orElse方法类似。与返回默认值不同，
            // orElseThrow会抛出lambda表达式或方法生成的异常
            empty.orElseThrow(ValueAbsentException::new);
        } catch (Throwable ex) {
            // 输出: No value present in the Optional instance
            System.out.println(ex.getMessage());
        }

        // map方法执行传入的lambda表达式参数对Optional实例的值进行修改。
        // 为lambda表达式的返回值创建新的Optional实例作为map方法的返回值。
        Optional<String> upperName = name.map((value) -> value.toUpperCase());
        System.out.println(upperName.orElse("No value found"));

        //flatMap与map（Function）非常类似，区别在于传入方法的lambda表达式的返回类型。
        //map方法中的lambda表达式返回值可以是任意类型，在map函数返回之前会包装为Optional。
        //但flatMap方法中的lambda表达式返回值必须是Optionl实例。
        upperName = name.flatMap((value) -> Optional.of(value.toUpperCase()));
        System.out.println(upperName.orElse("No value found"));//输出SANAULLA

        // filter方法检查给定的Option值是否满足某些条件。
        // 如果满足则返回同一个Option实例，否则返回空Optional。
        Optional<String> longName = name.filter((value) -> value.length() > 6);
        System.out.println(longName.orElse("The name is less than 6 characters"));// 输出Sanaulla
        // 另一个例子是Optional值不满足filter指定的条件。
        Optional<String> anotherName = Optional.of("Sana");
        Optional<String> shortName = anotherName.filter((value) -> value.length() > 6);
        // 输出：name长度不足6字符
        System.out.println(shortName.orElse("The name is less than 6 characters"));
    }
}
