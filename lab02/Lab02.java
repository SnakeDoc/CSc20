/**
  * Jason Sipula
  * CsC 20 - M/W 2PM
  * Lab 02
  * Section number: 4
  *
  */

import java.util.Scanner;

public class Lab02 {

	private int year;
	private int numberOfDaysInMonth;
        private final JulianDate jd = new JulianDate();

	public static void main(String[] args) {
	
	// instructor example
	//	JulianDate jd = new JulianDate();
	//        int date = jd.toJulian(2013,1,1);
	//	int dayOfWeek = (date + 1) % 7; // 0 means Sunday, 1 means Monday, etc.
	//
        Lab02 lb = new Lab02();
		
		if (args.length == 0) {
		
		    lb.setYear(lb.getUserInputYear());
		
		} else {
		
		    lb.setYear(Integer.parseInt(args[0]));
		
		}
		
		System.out.print("\n\n");
		
		lb.printYear();

        // start on 1st month (january)
        for (int month = 1; month <= 12; month++) {

            lb.printMonth(month);
            lb.printDaysOfWeek();
            lb.printDayNumbers(month);

        }
	
	}
	
	private int getUserInputYear() {
	
		System.out.print("\nEnter Year: ");
		return new Scanner(System.in).nextInt();
	
	}
	
	private void setYear(int year) {
	
		this.year = year;
	
	}
	
	private void printYear() {
	
		System.out.printf("%13s\n\n", this.year);
	
	}
	
	private void printDaysOfWeek() {
	
		System.out.print
		("  S  M Tu  W Th  F  S\n");
	
	}
	
	private void printMonth(int month) {
	
		switch(month) {
		
			case 1:
				System.out.printf("\n%15s\n\n", "January");
				numberOfDaysInMonth = 31;
				break;
			case 2:
				System.out.printf("\n %15s\n\n", "February");
				numberOfDaysInMonth = getFebruaryLength();
				break;
			case 3:
				System.out.printf("\n%13s\n\n", "March");
				numberOfDaysInMonth = 31;
				break;
			case 4:
				System.out.printf("\n%13s\n\n", "April");
				numberOfDaysInMonth = 30;
				break;
			case 5:
				System.out.printf("\n%12s\n\n", "May");
				numberOfDaysInMonth = 31;
				break;
			case 6:
				System.out.printf("\n%13s\n\n", "June");
				numberOfDaysInMonth = 30;
				break;
			case 7:
				System.out.printf("\n%13s\n\n", "July");
				numberOfDaysInMonth = 31;
				break;
			case 8:
				System.out.printf("\n%14s\n\n", "August");
				numberOfDaysInMonth = 31;
				break;
			case 9:
				System.out.printf("\n%15s\n\n", "September");
				numberOfDaysInMonth = 30;
				break;
			case 10:
				System.out.printf("\n%14s\n\n", "October");
				numberOfDaysInMonth = 31;
				break;
			case 11:
				System.out.printf("\n%15s\n\n", "November");
				numberOfDaysInMonth = 30;
				break;
			case 12:
				System.out.printf("\n%15s\n\n", "December");
				numberOfDaysInMonth = 31;
				break;
		
		}
	
	}

    private void printDayNumbers(int month) {

        int firstDayOfMonth = ((jd.toJulian(year, month, 1) + 1) % 7) + 1;

		if ((firstDayOfMonth - 1) > 0) {
		
			System.out.printf("%" + ((firstDayOfMonth - 1) * 3) + "c", ' ');
		
		}
        
		int currentDay = firstDayOfMonth;
        for (int j = 1; j <= numberOfDaysInMonth; j++) {
        
	        System.out.printf(" %2s", j);
	  
			if (currentDay == 7) {
	        
				System.out.print("\n");
				currentDay = 0;
			
			}
        
			currentDay++;
		
        }
		
		System.out.print("\n\n");

    }
        
    private int getFebruaryLength() {
        
		if ((year % 4 == 0) && year % 100 != 0) {
		
			return 29;
			
		} else if ((year % 4 == 0) && (year % 100 == 0) && (year % 400 == 0)) {
		
			return 29;
			
		} else {
		
			return 28;
			
		}
        
    }

}
