package java8.annotationtest;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME) // 该注解存在于类文件中并在运行时可以通过反射获取
@Repeatable(Annots.class)
public @interface Annot {
	String value();
}
