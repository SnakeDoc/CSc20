/**
 * Jason Sipula
 * Lab 06
 * CSc 20 - M/W 2pm
 * Section 4
 */

public class Queue {
	Object[] array = new Object[1024];
	
	public void enqueue(Object t) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == null) {
				array[i] = t;
			}
		}
	}
	
	public Object dequeue() {
		Object returnTkn = array[0];
		Object[] newArray = new Object[1024];
		for (int i = 0; i < (array.length - 1); i++) {
			newArray[i] = array[i + 1];
		}
	}
	
	public Object first() {
		return array[0];
	}
	
	public boolean isEmpty() {
		if (array != null && array[0] != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isFull() {
		if (array[1024] != null) {
			return false;
		} else {
			return true;
		}
	}
}
 