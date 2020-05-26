package com.java.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorExample {
	
	private ExecutorService executor = Executors.newSingleThreadExecutor();//newFixedThreadPool(2);
   
  public Future<Integer> calculate1(Integer input) {        
      return executor.submit(() -> {
    	  System.out.println("calculate1");
          Thread.sleep(1000);
          System.out.println("calculate1 Done");
          return input * input;
      });
  }
  
  public Future<Integer> calculate2(Integer input) {        
      return executor.submit(() -> {
    	  System.out.println("calculate2");
          Thread.sleep(1000);
          System.out.println("calculate2 Done");
          return input * input;
      });
  }
  
  public static void main(String args[]) {
	  System.out.println("Calculating for 10");
	  Future<Integer> future1 = new ExecutorExample().calculate1(10);
	  System.out.println("Calculating for 20");
	  Future<Integer> future2 = new ExecutorExample().calculate2(20);
	 try { 
		 while (!(future1.isDone() && future2.isDone())) {
			    System.out.println(
			      String.format(
			        "future1 is %s and future2 is %s", 
			        future1.isDone() ? "done" : "not done", 
			        future2.isDone() ? "done" : "not done"
			      )
			    );
			    Thread.sleep(300);
			}
	   
	  Integer result = future1.get();
	  System.out.println("Result from future1 :" + result);
	  System.out.println("Result from future2 :" + future2.get());
	  
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
  }

}
