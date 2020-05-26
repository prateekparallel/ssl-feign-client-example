package com.java.multithreading;

import java.util.concurrent.Semaphore;

class Writer{
	Semaphore semaphore = new Semaphore(4);
	public void write(String msg) {
		System.out.println("Waiting for lock :"+msg);
		try {
			Thread.sleep(1000);
			semaphore.acquire();
			System.out.println("Writing by :"+msg);
			Thread.sleep(4000);
			System.out.println("I am done :"+msg);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			semaphore.release();
		}
		
		
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
		writer.write(name);		
	}
	
}

public class SimaphoreExample {
	
	
	
	public static void main(String[] args) {
		// Java semaphone is working on FIFO
		Writer writer = new Writer();
		for(int i = 0; i < 8; i++) {
			Thread t = new Thread(new WriterThread("Thread -" + (i+1),writer));
			t.start();
		}
		try {
			Thread.sleep(1100);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(int i = 8; i < 18; i++) {
			Thread t = new Thread(new WriterThread("Thread -" + (i+1),writer));
			t.start();
		}
		
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
