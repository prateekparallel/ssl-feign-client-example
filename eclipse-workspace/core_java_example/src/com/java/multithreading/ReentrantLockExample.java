package com.java.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class SharedObject{
	
	ReadWriteLock rwLock = new ReentrantReadWriteLock();
	Lock readLock = rwLock.readLock();
	Lock writeLock = rwLock.writeLock();
	
	public void print(String msg) {
		readLock.lock();
		System.out.println(msg);
		readLock.unlock();
	}
	
	public void write(String msg) {
		writeLock.lock();
		System.out.println(msg);
		try {
	
			Thread.sleep(2000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writeLock.unlock();
		try {
			System.out.println("Writing done...");
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class ReadThread extends Thread{
	String name;
	boolean shouldContinue;
	
	SharedObject so;
	
	public ReadThread(String tname, SharedObject so) {
		name = tname;
		shouldContinue = true;
		this.so = so;
	}
	
	public void run() {
		while(shouldContinue) {
			so.print(name);
		}
	}
	
	public void stopThread() {
		shouldContinue = false;
	}
	
}


class WriteThread extends Thread{
	String name;
	boolean shouldContinue;
	
	SharedObject so;
	
	public WriteThread(String tname, SharedObject so) {
		name = tname;
		shouldContinue = true;
		this.so = so;
	}
	
	public void run() {
		while(shouldContinue) {
			so.write(name);
		}
	}
	
	public void stopThread() {
		shouldContinue = false;
	}
	
}

public class ReentrantLockExample {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SharedObject so = new SharedObject();
		
		ReadThread t1 = new ReadThread("Thread 1",so);
		ReadThread t2 = new ReadThread("Thread 2",so);
		ReadThread t3 = new ReadThread("Thread 3",so);
		ReadThread t4 = new ReadThread("Thread 4",so);
		ReadThread t5 = new ReadThread("Thread 5",so);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		try {
			Thread.sleep(100);
			WriteThread rt1 = new WriteThread("Write Thread 1",so);
			rt1.start();
			Thread.sleep(5000);
			rt1.stopThread();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t1.stopThread();
		t2.stopThread();
		t3.stopThread();
		t4.stopThread();
		t5.stopThread();
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
