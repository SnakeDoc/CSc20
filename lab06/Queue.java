/**
 * Jason Sipula
 * Lab 06
 * CSc 20 - M/W 2pm
 * Section 4
 */

public class Queue {

	private int front = 0;
	private int rear = -1;
	private int capacity = 1024;
	
	private Object S[] = new Object[capacity];
	
	public boolean isEmpty() {
		return front == (rear + 1) % capacity;
	}
	
	public void enqueue(Object Element) {
		rear = (rear + 1) % capacity;
		S[rear] = Element;
	}
	
	public Object dequeue() {
		Object Element = S[front];
		S[front] = null;
		front = (front + 1) % capacity;
		
		return Element;
	}
	
	public String toString() {
		String temp = "";
		for (int i = 0; i < S.length; i++) {
			if (S[i] != null) {
				temp += S[i].toString();
			}
		}
		return temp;
	}
	
/*
	Object[] array = new Object[1024];
	
	public void enqueue(Object t) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == null) {
				array[i] = t;
				return;
			}
		}
	}
	
	public Object dequeue() {
		Object returnTkn = array[0];
		Object[] newArray = new Object[1024];
		for (int i = 0; i < (array.length - 1); i++) {
			newArray[i] = array[i + 1];
		}
		return returnTkn;
	}
	
	public Object first() {
		return array[0];
	}
	
	public boolean isEmpty() {
		if (array != null) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean isFull() {
		if (array[1024] != null) {
			return false;
		} else {
			return true;
		}
	}
*/	
}
 