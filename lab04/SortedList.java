/**
  * Jason Sipula
  * CsC 20 - M/W 2PM
  * Lab 04
  * Section number: 4
  *
  */

public class SortedList {

	private DLNode Head, Tail;

	public void insert(double n){

		DLNode current;
        // find position and set other nodes
		current = Head;
		while (current != null && current.data < n) {
			current = current.Next;
		}
			
		DLNode prv = current == null ? Tail : current.Prev;

		DLNode tmp = new DLNode();
		tmp.data = n;

		if (prv != null) prv.Next = tmp;
		else Head = tmp;

		tmp.Prev = prv;
		tmp.Next = current;

		if (current != null) current.Prev = tmp;
		else Tail = tmp;
	}
		
	public void listAscending() {
	
		System.out.println("\n  Ascending  ");
	
		DLNode curNode = Head;
	
		int count = 0;
		while (curNode != null) {

			System.out.printf("%f ", curNode.data);
			count++;
			if (count == 5) {
				System.out.print("\n");
				count = 0;
			}
			curNode = curNode.Next;
		}
	}
	
	public void listDescending() {
	
		System.out.println("  Descending  ");
	
		DLNode curNode = Tail;
	
		int count = 0;
		while (curNode != null) {
		
			System.out.printf("%f ", curNode.data);
			count++;
			if (count == 5) {
				System.out.print("\n");
				count = 0;
			}
			curNode = curNode.Prev;
		}
	}
}
