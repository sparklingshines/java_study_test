package java8.functionalinterface.extendsparent.z7;

import java.io.IOException;
import java.sql.SQLTransientException;
import java.util.List;

@FunctionalInterface
public interface A {
	List<String> foo(List<String> arg) throws IOException, SQLTransientException;
}
