import java.io.File;
import java.util.Scanner;
import java.util.Stack;
import java.io.FileNotFoundException;

class Main {
  public static void main(String args[]) throws FileNotFoundException { 
    Scanner scan = new Scanner(new File("Calc1.stk")); //replace file name here
    Stack<Integer> stack = new Stack<Integer>();

    while(scan.hasNextLine()){
	        String line = scan.nextLine();
	        try {
	        	int i = Integer.parseInt(line);
	        	stack.push(i);
	        }
	        catch (Exception e)
	        {
	        	int top = stack.pop();
	        	int bot = stack.pop();
	        	
	        	if (line.equals("*")) {
	        		stack.push(bot*top);
	        	}
	        	else if (line.equals("/")) {
	        		stack.push(bot/top);
	        	}
	        	else if (line.equals("-")) {
	        		stack.push(bot-top);
	        	}
	        	else if (line.equals("+")) {
	        		stack.push(bot+top);
	        	}
	        }
	    }
	    System.out.println(stack.pop());
  } 
}
