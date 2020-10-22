package javaStudy;

public class StringBufferExam {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		sb.append("hello");
		sb.append(" ");
		sb.append("world");
		
		String str = sb.toString();
		System.out.println(str);
		
		StringBuffer sb2 = new StringBuffer();
		StringBuffer sb3 = sb2.append("hello"); 
		if(sb2 == sb3) 
			//@dec sb2가 자기 자신을 반환하므로 sb2 == sb3를 반환한다.
			//메소드 체이닝이라고 한다.(자기자신을 리턴하고 계속해서 자신의 메소드를 호출하는 방식.)
			System.out.println("sb2 == sb3");
		
		
		String str2 = new StringBuffer().append("hello").append(" ").append("world").toString(); 
		System.out.println(str2);
		
	}
}
