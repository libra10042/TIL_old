package javaUtilExam;

import java.util.Calendar;

public class CalendarExam {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH) + 1); //MONTH는 + 1을 해야 제대로 된 월에 대한 정보를 확인할 수 있다.
		System.out.println(cal.get(Calendar.DATE));
		
		System.out.println(cal.get(Calendar.HOUR)); //11
		System.out.println(cal.get(Calendar.HOUR_OF_DAY)); //23
		System.out.println(cal.get(Calendar.MINUTE));
		
		System.out.println("-----------------------");
		//5시간 후 정보
		cal.add(Calendar.HOUR, 5);
		
		
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH) + 1); //MONTH는 + 1을 해야 제대로 된 월에 대한 정보를 확인할 수 있다.
		System.out.println(cal.get(Calendar.DATE));
		
		System.out.println(cal.get(Calendar.HOUR)); //11
		System.out.println(cal.get(Calendar.HOUR_OF_DAY)); //23
		System.out.println(cal.get(Calendar.MINUTE));
		
	}
}
