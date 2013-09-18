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
        for (int month = 1; month < 12; month++) {

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
	
		System.out.printf
		("%3s %2s %s %2s %2s %2s %2s\n", "S", "M", "Tu", "W", "Th", "F", "S");
	
	}
	
	private void printMonth(int month) {
	
		switch(month) {
		
			case 1:
				System.out.printf("\n%15s\n\n", "January");
				break;
			case 2:
				System.out.printf("\n %15s\n\n", "February");
				break;
			case 3:
				System.out.printf("\n%13s\n\n", "March");
				break;
			case 4:
				System.out.printf("\n%13s\n\n", "April");
				break;
			case 5:
				System.out.printf("\n%12s\n\n", "May");
				break;
			case 6:
				System.out.printf("\n%13s\n\n", "June");
				break;
			case 7:
				System.out.printf("\n%13s\n\n", "July");
				break;
			case 8:
				System.out.printf("\n%14s\n\n", "August");
				break;
			case 9:
				System.out.printf("\n%15s\n\n", "September");
				break;
			case 10:
				System.out.printf("\n%14s\n\n", "October");
				break;
			case 11:
				System.out.printf("\n%15s\n\n", "November");
				break;
			case 12:
				System.out.printf("\n%15s\n\n", "December");
				break;
		
		}
	
	}

    private void printDayNumbers(int month) {

        jd.toJulian(year, month, 1);

    }

}
