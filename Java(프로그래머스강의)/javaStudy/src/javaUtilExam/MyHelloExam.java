package javaUtilExam;

import java.lang.reflect.Method;

public class MyHelloExam {
	public static void main(String[] args) {
		MyHello hello = new MyHello(); 
		
		try {
			Method method = hello.getClass().getDeclaredMethod("hello");
			
			if(method.isAnnotationPresent(Count100.class)) {
				for(int i=0; i<100; i++) {
					hello.hello();
				}
			}else {
				hello.hello();
			}
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
