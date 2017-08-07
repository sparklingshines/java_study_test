package java8.functionalinterface.extendsparent.z7;

import java.io.EOFException;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.TimeoutException;

@FunctionalInterface
public interface B {
	@SuppressWarnings("rawtypes")
	List foo(List<String> arg) throws EOFException, SQLException, TimeoutException;
}
