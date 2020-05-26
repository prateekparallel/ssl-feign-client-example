package com.java.memory;

import java.lang.ref.WeakReference;

abstract class SuperGarbage{
	
	//static method must be define immidiately
	//public static void test();
	
	@Override
	protected void finalize() throws Throwable
	{
		//this is clean up method
	    //Keep some resource closing operations here
		//this method will be call by gc method during garbage collection
		System.out.println("I am SuperGarbage and I am going out of the scope byeee");
		//try block is not mandatory even for a forced check execption
		//both below will work
		//Thread.sleep(1);
		try {
			//Thread.sleep(1);
		}catch(Exception e) {
			
		}finally {
			System.out.println("In finally");
		}
		
		
	}
}

class GarbageExample extends SuperGarbage{
	Integer integer[];
	
	public GarbageExample() {
		integer = new Integer[1000];
	}
	
	public boolean isAlive() {
		System.out.println("Yes I am alive");
		return true;
	}
	
	
	
	@Override
	protected void finalize() throws Throwable
	{
		//this is clean up method
	    //Keep some resource closing operations here
		//this method will be call by gc method during garbage collection
		System.out.println("I am going out of the scope byeee");
		//unlike C++ in java you have to call supper class finalize method
		super.finalize();
	}


}

public class JavaMemoryCalculation {
	
	public void outOfScopeExample() {
		GarbageExample ge = new GarbageExample();
		ge.isAlive();
		//now method will exit and ge will be out of scope
		//hence garbage collection bill be done and
		//finally method will be call
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GarbageExample ge1 = new GarbageExample();
		GarbageExample ge2 = new GarbageExample();	
		
		
		Runtime gfg = Runtime.getRuntime(); 
        long memory1, memory2; 
        Integer integer[] = new Integer[1000]; 
  
        // checking the total memeory 
        System.out.println("Total memory is: "
                           + gfg.totalMemory()); 
  
        // checking free memory 
        memory1 = gfg.freeMemory(); 
        System.out.println("Initial free memory: "
                                      + memory1); 
        
        ge1.isAlive();
       
       //old object referenced to ge1 will be out of scope
        //hence garbage collection will be done on the previous object
        //as ge1 is referenced to ge2
        //ge1 = ge2;
        ge1 = null;
        ge2 = null;
        // calling the garbage collector on demand 
        gfg.gc(); 
        
        //Also read for WeakReference and SoftReference
        
        JavaMemoryCalculation jmc = new JavaMemoryCalculation();
        jmc.outOfScopeExample();        
       
        memory1 = gfg.freeMemory(); 
  
        System.out.println("Free memory after garbage "
                           + "collection: " + memory1); 
  
        // allocating integers 
        for (int i = 0; i < 1000; i++) 
        	integer[i] = new Integer(i); 
        
        memory2 = gfg.freeMemory(); 
        System.out.println("Free memory after allocation: "
                           + memory2); 
  
        System.out.println("Memeory used by allocation: " + 
                                    (memory1 - memory2)); 
  
        // discard integers 
        for (int i = 0; i < 1000; i++) 
            integer[i] = null; 
  
        gfg.gc(); 
  
        memory2 = gfg.freeMemory(); 
        System.out.println("Free memeory after  "
            + "collecting discarded Integers: " + memory2);
        //read about WeekReference and Softreference
        WeakReference<GarbageExample> reference = new WeakReference<>(new GarbageExample());
        //GarbageExample g = reference.get();
        //g.isAlive();
        reference.get().isAlive();
        //Another way of calling garbage collection
        System.gc();
        
        //not allowed here you need a try catch block
        //Thread.sleep(1);
        
        //below code with through null pointer exception
        reference.get().isAlive();
        
        System.out.println("Free memeory finally :" + gfg.freeMemory());
        //jmc.isAlive();
        
        //how to forcefully run a finalize method on objects
        //Runtime.getRuntime().runFinalization();
       // Runtime.runFinalizersOnExit(true);
	}

}
