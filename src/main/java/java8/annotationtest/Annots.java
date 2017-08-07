package java8.annotationtest;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME) // 该注解存在于类文件中并在运行时可以通过反射获取
public @interface Annots {
	Annot[] value();
}
