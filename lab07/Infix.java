/**
 * Jason Sipula
 * Lab 06
 * CSc 20 Section 4 (M/W 2pm)
 */

// infix.java
import java.io.*;
//import MyStackQueue.*;

// for data format exception
import java.util.zip.DataFormatException;

class Infix {
	static Queue infixToPostfix(String s) throws Exception {
        Tokenizer tokenizer = new Tokenizer(s);
        Queue queue = new Queue();
        Stack stack = new Stack();
		stack.push(new Operator('#'));
        Token token;
        while ((token = tokenizer.nextToken()) != null) {
            if (token instanceof Operand) {
				queue.enqueue(token);
			} else if (token.toString().equals("(")) {
				stack.push(token);
			} else if (token.toString().equals(")")) {

					Token t = (Token) stack.top();
					try {
						while (!t.toString().equals("(")) {
							queue.enqueue(t);
							stack.pop();
							t = (Token) stack.top();
						}
					} catch (Exception e) {
						throw new TooManyRight();
					}	
						stack.pop(); // remove '(' from stack

			} else {
				Operator op = (Operator) token;
				Operator top = null;
				top = (Operator)stack.top();
				while (op.precedence() <= top.precedence()) {
					queue.enqueue(stack.pop());
					top = (Operator)stack.top();
				}
				stack.push(op);
			}
        }
		
		if (token == null) {
			while(!stack.isEmpty()) {
			Operator top = (Operator) stack.top();
				if (top.operator == '(') {
						throw new TooManyLeft();
				}
				Token o = (Token)stack.pop();
				if (o.toString().equals("#")) {
					break;
				}
				if (o instanceof Operator) {
					queue.enqueue(o);
				}
			}
			if (!stack.isEmpty()) {
				stack.pop();
			}
		}
		return queue;
	}

	static int evaluatePostfix(Queue Post) throws Exception {
		Stack stack = new Stack();
		Token cur;
		while (!Post.isEmpty()) {
			cur = (Token)Post.dequeue();
			if (cur instanceof Operand) {
				stack.push(cur);
			} else if (cur instanceof Operator) {
				Operator curr = (Operator) cur;
				int temp = 0;
				try {

					Operand x = (Operand)stack.pop();
					Operand y = null;

					y = (Operand)stack.pop();
					if (curr.toString().equals("+")) {
						temp = Integer.parseInt(y.toString()) + Integer.parseInt(x.toString());
						stack.push(new Operand(temp));
					} else if (curr.toString().equals("-")) {
						temp = Integer.parseInt(y.toString()) - Integer.parseInt(x.toString());
						stack.push(new Operand(temp));
					} else if (curr.toString().equals("*")) {
						temp = Integer.parseInt(y.toString()) * Integer.parseInt(x.toString());
						stack.push(new Operand(temp));
					} else if (curr.toString().equals("/")) {
						temp = Integer.parseInt(y.toString()) / Integer.parseInt(x.toString());
						stack.push(new Operand(temp));
					}

				} catch (Exception e) {
					throw new TooManyOperator();
				}
			}
		}
		// final number
		int finalInt = Integer.parseInt(stack.pop().toString());
		if(!stack.isEmpty())
			throw new TooManyOperand();
		return finalInt;
	}

	public static void main(String[] args) throws IOException {
		Queue Post;
		while(true) {
			System.out.print("Enter infix: ");
			System.out.flush();
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			String s = br.readLine();
			if ( s.equals("") ) break;
			try {
				Post = infixToPostfix(s);
				System.out.println("Postfix is " + Post.toString() + '\n');
				int result = evaluatePostfix(Post);
				System.out.println("Result is " + result + '\n');
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}
	}
}

class TooManyLeft extends Exception {
	public String toString() { return "**** Too Many ( ****\n"; }
}
class TooManyRight extends Exception {
	public String toString() { return "**** Too Many ) ****\n"; }
}
class TooManyOperand  extends Exception {
	public String toString() { return "**** Too Many Operand ****\n"; }
}
class TooManyOperator  extends Exception {
	public String toString() { return "**** Too Many Operator ****\n"; }
}
