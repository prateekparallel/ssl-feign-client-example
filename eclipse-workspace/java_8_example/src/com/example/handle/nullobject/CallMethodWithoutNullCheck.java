package com.example.handle.nullobject;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;

@FunctionalInterface
interface CFunction<T,R>{
	R execute(T t);
	
	//In a FI only a single abstract method allowed so below declaration is not allowed
	
	/* R apply(T t, R r); */
	
	//Functional interface allow default method but 
	//does not allow default implementation of the method
	//for lambda expansion hence can not implement default behaviour
	//of above execute method
	default R apply(T t) {
        return apply(t);
    }
}

class NullSafe{

  /* public static <T1, R> R executeNullSafe(T1 c, Function<T1,R> lambda ) {
	   if(c == null) {
		   return null;
	   }
	   return lambda.apply(c);
	} */
   /***
    * 
    * @param <T>
    * @param <R>
    * @param t
    * @param lambda
    * @return
    */
   public static <T, R> R executeNullSafe(T t, CFunction<T, R> lambda ) {
	   if(t == null) {
		   return null;
	   }
	   return lambda.execute(t);
	}  
}


public class CallMethodWithoutNullCheck {
	
	String name;
	
	public CallMethodWithoutNullCheck() {
		this.name = "NullCeck";
	}
	
	public String getFullName(String lname) {
		return this.name + " " + lname;
	}
	
	public String getName() {
		return this.name;
	}
	
	public static void main(String args[]) {
		
		CallMethodWithoutNullCheck cmnc = new CallMethodWithoutNullCheck();
		
	   String val = NullSafe.executeNullSafe(cmnc, cmn -> cmn.getName());
	   
	   System.out.println("Value is :" + val);
	   
	   val = NullSafe.executeNullSafe(cmnc, cmn -> cmn.getFullName("Dutta"));
	   
	   System.out.println("Value is :" + val);
	   
	   System.out.println("Stream without terminal operation");
	    
	   //Stream with intermediate operation and 
	   
	    Arrays.stream(new int[] { 1, 2, 3 }).map(i -> {
	        System.out.println("doubling " + i);
	        return i * 2;
	    });
	    
	  //terminal operation.
	    System.out.println("Stream with terminal operation");
        Arrays.stream(new int[] { 1, 2, 3 }).map(i -> {
            System.out.println("doubling " + i);
            return i * 2;
    }).sum();
		
	}

}
