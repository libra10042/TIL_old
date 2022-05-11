package javaUtilExam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class TimeExam {
	public static void main(String[] args) {
		
		//���� ��¥�� �ð�
		LocalDateTime timePoint = LocalDateTime.now();
		
		//���ϴ� �ð����� time ��ü �����ϴ� ���. 
		LocalDate id1 = LocalDate.of(2012, Month.DECEMBER, 12);
		System.out.println(id1);
		
		// 17�� 18�п� ���� LocalTime ��ü�� ���Ѵ�.
		LocalTime lt1 = LocalTime.of(17, 18);
		System.out.println(lt1);
		
		
		//10�� 15�� 30��� ���ڿ��� ���� LocalTime ��ü�� ���Ѵ�.
		LocalTime lt2 = LocalTime.parse("10:15:30");
		System.out.println(lt2);
		
		LocalDate theDate = timePoint.toLocalDate();
		System.out.println(theDate);
		
		//Calender�� �ٸ��� month + 1 �� ���� �ʾƵ� �ȴ�.
		Month month = timePoint.getMonth();
		System.out.println(timePoint.getMonthValue());
		System.out.println(month.getValue());
		System.out.println(timePoint.getHour());
		
		
		
	}
}
