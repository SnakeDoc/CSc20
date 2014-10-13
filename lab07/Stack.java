/**
 * Jason Sipula
 * Lab 06
 * CSc 20 - M/W 2pm
 * Section 4
 */

public class Stack {
	
	private Node Top = null;
	private int size = 0;
	
	public boolean isEmpty() {
		return (Top == null);
	}
	
	public Object top() {
		return Top.obj;
	}
	
	public void push(Object element) {
		Node tmp = new Node(element);
		tmp.Next = Top;
		Top = tmp;
		size++;
	}
	
	public Object pop() {
		Node tmp = Top;
		Top = Top.Next;
		size--;
		return (Token)tmp.obj;
	}
	
}
  