package com.inharitance.example;

public class SubClassForBaseInterface implements BaseInterface {

	@Override
	public void testAbstractFromInterface() {
		// TODO Auto-generated method stub
		System.out.println("I am sub class implementation :" + number);
		
		//Not allowed interface private method is not allowed to call from sub class
		//testPrivateInterfaceMethod();
		
		//Not allowed it is final by default
		//number = 11;
		
		//static with interface reference allowed
		BaseInterface.testStatic();
		
		//default allowed without interface reference
		//testDefaultFromInterface();
	}
	 //below is not allowed
	//@Override
	//void testPrivateInterfaceMethod() {
	//}
	
	public void testDefaultFromInterface() {
		System.out.println("I am  testDefaultFromInterface from sub class");
	}
	
	public static void main(String args[]) {
		SubClassForBaseInterface sub = new SubClassForBaseInterface();
		sub.testAbstractFromInterface();//OK
		sub.testDefaultFromInterface();//OK
		//sub.testPrivateInterfaceMethod()// not ok not allowed to call a private method of Interface
	}
	

}
