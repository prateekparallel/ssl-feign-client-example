package com.inharitance.example;

public abstract class BaseAbstract {
	public int number = 10;
	
	private static void test() {
		System.out.println("I am BaseBaseAbstract private static method");
	}
	
	public static void testStatic() {
		System.out.println("I am BaseBaseAbstract public testStatic method");
	}
	
	//private method are not considered as abstract
	//you can not override it in sub class
	private void testPrivateBaseAbstractMethod() {
		System.out.println("I am testPrivateBaseAbstractMethod private method from BaseBaseAbstract");
		//calling static method from here
		test(); //No need to use BaseBaseAbstract.test();
		//BaseBaseAbstract.test();
	}
	
	//Not allowed better declare a private for this kind of requirement
	//final void testFinalMethod() {}
	
	//a abstract method must be override in sub class
	//in a abstract class abstract method must be
	//declared with keyword abstract
	public abstract void testAbstractFromBaseAbstract();
	
	//default
	//below declaration is not allowed
	//private default void testDefaultFromBaseAbstract() {
	//}
	
	//by default method are public in java
	void testDefaultFromBaseAbstract() {
		System.out.println("I am  testDefaultFromBaseAbstract from BaseAbstract");
	}

	void testDefaultImplementationOfAbstractClass() {
		System.out.println("I am testDefaultImplementation");
	}
}
