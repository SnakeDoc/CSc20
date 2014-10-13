/**
 * Jason Sipula
 * Lab 06
 * CSc 20 - M/W 2pm
 * Section 4
 */
class Tokenizer { 
	private char [] buf; 
	private int cur; 
 
	Tokenizer(String infixExpression) { 
		buf = infixExpression.toCharArray(); 
		cur = 0; 
	} 

	Token nextToken() { 
	
	//1. Skip blanks.
	for (; cur < buf.length && buf[cur] == ' '; cur++){};
	
	//2. if (cur>=Buf.length) return null;
	if (cur >= buf.length) {
		return null;
	}
	
	//3. If the next character is a digit, keep reading until a non-digit is read.
	//		Convert the string of digits into an integer.
	char current = buf[cur];
	Token token;
	// validate if current character is a number
	if (current >= '0' && current <= '9') {
		int i = 0;
		int j = cur;
		
		while (true) {
			if (current < '0' || current > '9') {
				break;
			}
			i++;
			cur++;
			
			if (cur >= buf.length) {
				break;
			}
			
			current = buf[cur];
		}
		
		String tempStr = new String(buf, j, i);
		int num = Integer.valueOf(tempStr).intValue();
		token = new Operand(num);
	} else {
		//4. Otherwise, use the next character to create and return an operator.
		token = new Operator(current);
		cur++;
	}
	
	//Create and return an operand.
	return token;
	} 
} 