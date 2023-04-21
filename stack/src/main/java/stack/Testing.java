package stack;

import java.util.ArrayList;
import java.util.Stack;

public class Testing {

	public static void main(String[] args) {

		ArrayList<String> myList = new ArrayList<String>();
		
		Stack<Integer> stack = new Stack<Integer>();

		// push elements onto the stack
		stack.push(1);
		stack.push(2);
		stack.push(3);

		// pop elements from the stack
		int poppedElement = stack.pop();
		System.out.println("Popped element: " + poppedElement);

		// get the top element without removing it
		int topElement = stack.peek();
		System.out.println("Top element: " + topElement);

		// check if the stack is empty
		boolean isEmpty = stack.isEmpty();
		System.out.println("Is stack empty? " + isEmpty);

		// get the size of the stack
		int size = stack.size();
		System.out.println("Stack size: " + size);

	}
}
