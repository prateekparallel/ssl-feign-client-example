package com.java.multithreading;

public class ExceptionInSynchMethod {
	
	//We are testing two things here. One whether exception inside a synch method
	//create deadlock or not(outcome is no) and if one synch method is call by a thread
	//whether rest of all thread have to wait to call other sync methods
	//that means whether two synchronize method can be call parallel or not(out come is no)
	//during testing uncomment exc.charAt(10); to test exception condition
	//and remove synchronized key word from a method and test

	class Writer{		
		
		public synchronized void write(String msg){
			String exc = null;
			System.out.println("In Write I am  :"+msg);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//exception inside a synchronized method or block 
			//does not create deadlock
			//exc.charAt(10);//throw exception here
			
			System.out.println("From write I am Exiting :" + msg);
		}
		
		public synchronized void writeLate(String msg){
			System.out.println("In writeLate I am  :"+msg);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
						
			System.out.println("From writeLate I am Exiting :" + msg);
		}
	}

	class WriterThread implements Runnable{
		
		String name;
		Writer writer;
		
		public WriterThread(String name, Writer writer) {
			this.name = name;
			this.writer = writer;
		}
		
		public void run() {
			if(name.equals("Thread 1")) {
				writer.write(name);	
			}
			else {
				writer.writeLate(name);
			}
		}
		
	}
	
	public void testExceptionInSynchMethod() {
		Writer writer = new Writer();
		
		Thread t1 = new Thread(new WriterThread("Thread 1", writer));
		Thread t2 = new Thread(new WriterThread("Thread 2", writer));
		t1.start();
		t2.start();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) {
		ExceptionInSynchMethod eism = new ExceptionInSynchMethod();
		eism.testExceptionInSynchMethod();
	}

}
