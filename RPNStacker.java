package RPN;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.io.FileNotFoundException;

class Main {
  public static void main(String args[]) throws FileNotFoundException { 
    Scanner scan = new Scanner(new File("Calc1.stk"));
    Stack<Integer> stack = new Stack<Integer>();
    
    List<Token> tokens = new ArrayList<Token>();

    while(scan.hasNextLine()){
    	if (scan.hasNextInt())
    	{
    		String num = scan.nextLine();
    		tokens.add(new Token(TokenType.NUM, num));
    		stack.push(Integer.parseInt(num));
    	} else {
    		String value = scan.nextLine();
        	
        	if (value.equals("*")) {
        		int top = stack.pop();
            	int bot = stack.pop();
        		stack.push(bot*top);
        		tokens.add(new Token(TokenType.STAR, value));
        	}
        	else if (value.equals("/")) {
        		int top = stack.pop();
            	int bot = stack.pop();
        		stack.push(bot/top);
        		tokens.add(new Token(TokenType.SLASH, value));
        	}
        	else if (value.equals("-")) {
        		int top = stack.pop();
            	int bot = stack.pop();
        		stack.push(bot-top);
        		tokens.add(new Token(TokenType.MINUS, value));
        	}
        	else if (value.equals("+")) {
        		int top = stack.pop();
            	int bot = stack.pop();
        		stack.push(bot+top);
        		tokens.add(new Token(TokenType.PLUS, value));
        	} else {
        		System.out.println("Error: Unexpected character: " + value);
        		return;
        	}
    	}
    }
	    System.out.println(stack.pop());
	    for (int i = 0; i < tokens.size(); i++)
	    {
	    	System.out.println(tokens.get(i).toString());
	    }
  } 
}
