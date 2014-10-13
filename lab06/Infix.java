/**
 * Jason Sipula
 * Lab 06
 * CSc 20 Section 4 (M/W 2pm)
 */

// infix.java
import java.io.*;
//import MyStackQueue.*;

class Infix {
	static Queue infixToPostfix(String s) {
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
					while (!t.toString().equals("(")) {
						queue.enqueue(t);
						stack.pop();
						t = (Token) stack.top();

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

	static int evaluatePostfix(Queue Post) {
		Stack stack = new Stack();
		Token cur;
		while (!Post.isEmpty()) {
			cur = (Token)Post.dequeue();
			if (cur instanceof Operand) {
				stack.push(cur);
			} else if (cur instanceof Operator) {
				Operator curr = (Operator) cur;
				int temp = 0;
				if (!stack.isEmpty()) {
					Operand x = (Operand)stack.pop();
					Operand y = null;
					if (!stack.isEmpty()) {
						y = (Operand)stack.pop();
					} else {
						return Integer.parseInt(x.toString());
					}
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
				}
			}
		}
		// final number
		int finalInt = Integer.parseInt(stack.pop().toString());
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
			Post = infixToPostfix(s);
			System.out.println("Postfix is " + Post.toString() + '\n');
			int result = evaluatePostfix(Post);
			System.out.println("Result is " + result + '\n');
		}
	}
}
