package com.example.optional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class NullHandle {
	
	public boolean isVallueAvailable() {
		return true;
	}
	
	public static void main(String args[]) {
		
		Map<String,NullHandle> list = new HashMap<String,NullHandle>();
		
		NullHandle nh = new NullHandle();
		
		
		list.put("A1", nh);
		
		if (Optional.ofNullable(list.get("A2")).map(NullHandle::isVallueAvailable).orElse(false)) {
			System.out.println("True");
		}
		else {
			System.out.println("False");
		}
		
		Thread thread = new Thread(() -> System.out.println("Hello World!"));
		thread.start();
		
	}

}
