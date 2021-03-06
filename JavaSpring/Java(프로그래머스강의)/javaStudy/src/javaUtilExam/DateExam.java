package javaUtilExam;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExam {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date.toString()); //현재 날짜가 출력된다.
		
		
		//@desc  월은 MM 대문자로 표시한다.(분도 mm이므로)
		SimpleDateFormat ft = new SimpleDateFormat("yyyy.MM.dd 'at' hh:mm:ss a zzz");
		
		
		System.out.println(ft.format(date));
		
		
		System.out.println(date.getTime());
		
		long today = System.currentTimeMillis();
		System.out.println(today);
		
		System.out.println(today - date.getTime());
		
	
		
		 SimpleDateFormat ft2 = new SimpleDateFormat("yyyy년MM월dd일");
	        
	     String result = ft2.format(date);
	     System.out.println(date.getDate() + 100);
	        
	}
}
