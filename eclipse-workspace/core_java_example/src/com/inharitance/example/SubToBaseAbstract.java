package com.inharitance.example;

public class SubToBaseAbstract extends BaseAbstract{

	@Override
	public void testAbstractFromBaseAbstract() {
		// TODO Auto-generated method stub
		System.out.println(" I am testAbstractFromBaseAbstract in sub :" + number);
		number = 12; //Ok not final by default
		
		//private method of base class not allowed
		//only allowed from member method of abstract class or interface
		//testPrivateBaseAbstractMethod();
	}
	
	void testDefaultImplementationOfAbstractClass() {
		System.out.println("I am testDefaultImplementationOfAbstractClass defined in sub class");
	}	
	
	public static void main(String args[]) {
		BaseAbstract obj = new SubToBaseAbstract();
		obj.testDefaultImplementationOfAbstractClass();//with call sub class method
		obj.testAbstractFromBaseAbstract();
		obj.testDefaultFromBaseAbstract();//No override in sub class
	}

}
