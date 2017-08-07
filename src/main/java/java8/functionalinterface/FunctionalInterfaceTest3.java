package java8.functionalinterface;

@FunctionalInterface
public interface FunctionalInterfaceTest3 {
	
	public abstract void run();
	
	@Override
	String toString();
	
	@Override
	boolean equals(Object obj);
	
	@Override
	int hashCode();
	
}
