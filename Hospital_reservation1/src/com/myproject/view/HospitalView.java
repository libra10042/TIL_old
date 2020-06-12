package com.myproject.view;

import java.util.Scanner;

public class HospitalView {
	private Scanner sc = new Scanner(System.in);
	private Scanner scLine = new Scanner(System.in);
	private int choice; 
	
	private boolean flag = true;
	
	public HospitalView() {
		
		while(flag) {
			
			Home();
			choice = sc.nextInt(); 
			switch(choice) {
			case 1: 
				visitView(); 
				break;
				
			case 2: 
				reserveAndCancel(); 
				break;
				
			case 3: 
				DoctorIntroduce();
				break;
				
			case 4:
				CustomerInfo();
				break;
			
			
			
			
			
			}
			
		}
	
	
	}
	
	
	
	//---------------------------------------1. Áø·á ¿¹¾à -------------------------------------------
	public void Home() {
		System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
		System.out.println("¦¢1. Áø·á¿¹¾àÇÏ±â                    ¦¢");
		System.out.println("¦¢2. ¿¹¾àÁ¶È¸ ¹× ¿¹¾à Ãë¼Ò        ¦¢" );
		System.out.println("¦¢3. ÀÇ·áÁø ¼Ò°³                      ¦¢");
		System.out.println("¦¢4. °í°´Á¤º¸                          ¦¢");
		System.out.println("¦¢5. Á¾·á                                ¦¢");
		System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");
		System.out.print(">>");
	}
	
	
	
	
	
	//1-1. Áø·á¿¹¾à   
	public void visitView() {
		System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
		System.out.println("¦¢1.Ã³À½¹æ¹®        ¦¢");
		System.out.println("¦¢2.±âÁ¸¹æ¹®        ¦¢");
		System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");
		System.out.println(">>");
		choice = sc.nextInt(); 
		switch(choice) {
		case 1:
			System.out.println("Áø·á ¿¹¾àÀ» À§ÇÑ ÇÊ¼öÁ¤º¸¸¦ ÀÔ·ÂÇÕ´Ï´Ù.");
			// °í°´¸í, °í°´¹øÈ£, ÁÖ¹Îµî·Ï¹øÈ£, ÀüÈ­¹øÈ£, Áõ»ó ÀÔ·Â ¸ðµÎ ´Ù ÀÔ·Â Çßµû¸é Áõ»óÀÔ·Â Ã¢ Ãâ·Â
			//if()ÂüÀÌ¸é Áõ»ó¿¡ ÇØ´çÇÏ´Â ¹øÈ£ ­ˆ·Â. 
			
			
			break;
			
		case 2:
			//È¯ÀÚ¹øÈ£ ÀÔ·Â
			System.out.println("È¯ÀÚ ¹øÈ£¸¦ ÀÔ·ÂÇÏ¼¼¿ä :");
			
			
			break;
		}
	}
	
	//1-2. Áø·á ¼±ÅÃ
	public void careCheck() {
		System.out.println("-----º¸±â-----");
		System.out.println("1. ³»°ú,    2. ¿Ü°ú,    3.¼Ò¾Æ°ú,    4.Á¤Çü¿Ü°ú,    5.¾È°ú");
		System.out.print(">>");
		choice = sc.nextInt(); 
		scLine.nextLine(); 
		switch(choice) {
		// °ú¸¦ ¼±ÅÃÇÏ¸é °ú¿¡¼­ ÀÏÇÏ°í °è½Ã´Â ¼±»ý´ÔµéÀ» ¼±ÅÃÇÒ ¼ö ÀÖ´Ù. ¿¹¾à ³¯ÀÚ¸¦ ¼±ÅÃÇÑ´Ù. ¿¹¾à³¯Â¥¸¦ ¼±ÅÃÇÏ¸é ¿¹¾à½ÅÃ»ÀÌ ¿Ï·áµÈ´Ù. 
		case 1:
			
			break;
			
		case 2:
			break;
		
		}
		
	}
	
	
	public void reserveAndCancel() {
		System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
		System.out.println("¦¢·Î±×ÀÎ À¯ÇüÀ» ¼±ÅÃÇØÁÖ¼¼¿ä¦¢");
		System.out.println("¦¢1. °í°´                         ¦¢");
		System.out.println("¦¢2. Á÷¿ø                         ¦¢");
		System.out.println("¦¢3. ÀÌÀüÀ¸·Î                   ¦¢");
		System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");
		System.out.print(">>");
		scLine.nextLine(); 
	}
	
	
	
	
	//¿¹¾àÁ¶È¸ ¹× ¿¹¾à Ãë¼Ò
	public void DoctorInfo() {
		
	}
	
	//ÀÇ·áÁø ¼Ò°³
	public void DoctorIntroduce() {
		System.out.println("ÀÇ·áÁø ¼Ò°³");
		System.out.printf("%-20s%-25s%-20s%-25s%-20s%n", "¹øÈ£", "ÀÌ¸§", "Àü°ø", "ÇÐ·Â", "°æ·Â" );
		System.out.println("======================================================");
		System.out.printf("%-10s%-20s%-20s%-20s%-20s%n", "1", "ÀÌÃæÁø", "³»°ú", "¼­¿ï´ë Á¹¾÷", "¼¼ºê¶õ½ºº´¿ø10³â °æ·Â");
		System.out.printf("%-10s%-20s%-20s%-20s%-20s%n", "2", "±è°ÇÈñ", "¿Ü°ú", "°æÈñ´ëÁ¹¾÷", "º»º´¿ø15³âÂ÷");
		System.out.printf("%-10s%-20s%-20s%-20s%-20s%n", "3", "½ÉÀç¿ë", "¼Ò¾Æ°ú", "¿¬¼¼´ë Á¹¾÷", "¼¼ºê¶õ½ºº´¿ø 5³â°æ·Â");
		System.out.printf("%-10s%-20s%-20s%-20s%-20s%n", "4", "±èÃá¿Á", "Á¤¿µ¿Ü°ú", "ÇÑ¾ç´ëÁ¹¾÷", "ÇÑ¾ç´ëº´¿ø 15³â°æ·Â");
		System.out.printf("%-10s%-20s%-20s%-20s%-20s%n", "5", "½Å´ÙÇý", "¾È°ú", "°í·Á´ë Á¹¾÷", "º»º´¿ø 1³âÂ÷");
		System.out.printf("%-10s%-20s%-20s%-20s%-20s%n", "6", "±è¿µ½Ä", "³»°ú", "°Ç±¹´ë Á¹¾÷", "°Ç´ëº´¿ø 5³â°æ·Â");
		System.out.printf("%-10s%-20s%-20s%-20s%-20s%n", "7", "¹ÚÇý¼ø", "¿Ü°ú", "¼­¿ï´ë Á¹¾÷", "º»º´¿ø 10³âÂ÷");
		System.out.printf("%-10s%-20s%-20s%-20s%-20s%n", "8", "¼º¿ì¼º", "¼Ò¾Æ°ú", "¿¬¼¼´ë Á¹¾÷", "º» º´¿ø 30³âÂ÷");
		System.out.printf("%-10s%-20s%-20s%-20s%-20s%n", "9", "¼Õ±â¿µ", "Á¤Çü¿Ü°ú", "ÇÑ¾ç´ë Á¹¾÷", "º»º´¿ø 10³âÂ÷");
		System.out.printf("%-10s%-20s%-20s%-20s%-20s%n", "10", "Á¶È«ÁØ", "¾È°ú", "°Ç±¹´ë Á¹¾÷", "°Ç´ëº´¿ø5³â °æ·Â");
		
	
	}
	
	
	
	//°í°´Á¤º¸
	public void CustomerInfo() {
		System.out.println("¿øÇÏ½Ã´Â ¸Þ´º¸¦ ¼±ÅÃÇÏ¼¼¿ä");
		System.out.println("1. °í°´µî·ÏÀüÈ­¹øÈ£ º¯°æ");
		System.out.println("2. °í°´¹øÈ£ ºÐ½Ç");
		
	}
	
	


	
	
}
