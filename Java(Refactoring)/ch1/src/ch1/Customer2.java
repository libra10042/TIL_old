package ch1;

import java.util.Enumeration;
import java.util.Vector;
//@desc refactoring 후 class
public class Customer2 {
	private String _name;
	private Vector<Rental> _rentals = new Vector();

	public Customer2(String name) {
		_name = name;
	}

	public void addRental(Rental arg) {
		_rentals.addElement(arg);
	}

	public String getName() {
		return _name;
	}
	
	private double amountFor(Rental aRental) {
		return aRental.getCharge();
	}
	
	

	public String statement() {
		int frequentRenterPoints = 0;
		Enumeration<Rental> rentals = _rentals.elements();
		String result = getName() + " 고객님의 대여 기록\n";
		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();

			//경우에 따른 적립 포인트 지급 함수를 호출
			frequentRenterPoints += each.getFrequentRenterPoints();

			// 이번에 대여하는 비디오 정보와 대여료를 출력
			result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";

		}
		// 푸터 행 추가
		result += "누적 대여료 : " + String.valueOf(getTotalCharge()) + "\n";
		result += "적립 포인트 : " + String.valueOf(getTotalFrequentRenterPoints());
		return result;

	}
	
	//현재 까지 누적된 총 대여료
	private double getTotalCharge() {
		double result = 0; 
		Enumeration<Rental> rentals = _rentals.elements();
		while(rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			result += each.getCharge();
		}
		return result; 
	}

	private int getTotalFrequentRenterPoints() {
		int result = 0; 
		Enumeration<Rental>	 rentals = _rentals.elements();
		while(rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			result += each.getFrequentRenterPoints();
		}
		return result; 
	}
	
	
	
	
}
