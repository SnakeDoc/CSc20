/**
  * Jason Sipula
  * CsC 20 - M/W 2PM
  * Lab 04
  * Section number: 4
  *
  */
  
public class Student_Lab04 {

    public static void main(String[] args) {

		Math.random(); // seed the generator
	
        SortedList list = new SortedList();
		
		// load the list
		for (int i = 0; i < 100; i++) {
		
			list.insert(Math.random());
		
		}
		
		// print list in ascending order
		list.listAscending();
		
		System.out.print("\n\n");
		
		// print list in descending order
		list.listDescending();
		
		System.out.print("\n\n");

    }

}
