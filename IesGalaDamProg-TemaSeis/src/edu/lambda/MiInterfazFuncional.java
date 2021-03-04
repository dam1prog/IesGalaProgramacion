package edu.lambda;

@FunctionalInterface
public interface MiInterfazFuncional {
	default void saluda() {
		System.out.println("Un saludo!");
	}
	public abstract int calcula(int dato1, int 
			dato2);
}
