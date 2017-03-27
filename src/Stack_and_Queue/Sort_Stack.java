package Stack_and_Queue;

import java.util.Stack;

public class Sort_Stack {

	public static void main(String[] args) {

	}

	public static Stack<Integer> sort(Stack<Integer> stack) {
		Stack<Integer> result = new Stack<Integer>();
		while (!stack.isEmpty()) {
			int temp = stack.pop();
			while (!result.isEmpty() && result.peek() > temp) {
				stack.push(result.pop());
			}
			result.push(temp);
		}
		return result;
	}
}
