package Stack_and_Queue;

import java.util.Stack;

public class Stack_with_Min {

	Stack<Integer> stack1 = new Stack<>();
	Stack<Integer> stack2 = new Stack<>();

	public static void main(String[] args) {

	}

	public void push(int val) {
		stack1.push(val);
		if (stack2.isEmpty() || val <= stack2.peek()) {
			stack2.push(val);
		} else {
			stack2.push(stack2.peek());
		}
	}

	public int pop() {
		if (stack1.isEmpty() || stack2.isEmpty()) {
			return -1;
		}
		stack2.pop();
		return stack1.pop();
	}

	public int min() {
		if (stack2.isEmpty()) {
			return -1;
		}
		return stack2.peek();
	}
}
