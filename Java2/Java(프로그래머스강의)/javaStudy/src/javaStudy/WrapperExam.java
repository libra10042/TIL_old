package javaStudy;

public class WrapperExam {
	public static void main(String[] args) {
		int i =5; 
		Integer i2 = new Integer(5);
		
		//@desc 오토박싱 기본 데이터를 객체 타입의 데이터로 자동 형변환 시켜주는 기능.  
		//Integer i3 = new Integer(5); 
		Integer i3 = 5; //위 코드와 같다.    
		
		//@desc 오토 언박싱이라고 한다.
		int i5 = i3;
		
		
		
		
	}
}
