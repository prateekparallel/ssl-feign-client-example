package com.inharitance.example;

public interface BaseInterface {
	
	//public and final
	int number = 10;
	
	private static void test() {
		System.out.println("I am BaseInterface private static method");
	}
	
	public static void testStatic() {
		System.out.println("I am BaseInterface public testStatic method");
	}
	
	//private method are not considered as abstract
	//you can not override it in sub class
	private void testPrivateInterfaceMethod() {
		System.out.println("I am testPrivateInterfaceMethod private method from BaseInterface");
		//calling static method from here
		test(); //No need to use BaseInterface.test();
		//BaseInterface.test();	
	}
	
	//protected not allowed in interface
	//protected void testProtectedInterfaceMethod() {}
		
	
	//Not allowed better declare a private for this kind of requirement
	//final void testFinalMethod() {}
	
	//a abstract method must be override in sub class
	public void testAbstractFromInterface();
	
	//default
	//below declaration is not allowed
	//private default void testDefaultFromInterface() {
	//}
	
	//by default all method are public 
	//so below method is a public so public key work is not mandatory
	default void testDefaultFromInterface() {
		System.out.println("I am  testDefaultFromInterface from interface");
		
		//we can call a private method from a default method
		testPrivateInterfaceMethod();
	}

	//Not allowed must use default key word 
	//all public method if not default are considered as abstract in a interface
	//
	//void testautoDefault() {
	//}
}
