package edu.lambda;

public class TestInterfazFuncional {
	public static void main(String[] args) {
		MiInterfazFuncional mif = (oper1,oper2) -> oper1*oper2;
		
		mif.saluda();
		System.out.println(mif.calcula(3, 4));
	}
}
