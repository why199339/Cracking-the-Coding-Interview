package Stack_and_Queue;

import java.util.Stack;

public class My_Queue {

	Stack<Integer> stack1 = new Stack<>();
	Stack<Integer> stack2 = new Stack<>();

	public static void main(String[] args) {

	}

	public void add(int val) {
		stack1.push(val);
	}

	public int remove() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		if (stack2.isEmpty()) {
			System.out.println("Error");
		}
		return stack2.pop();
	}
}
