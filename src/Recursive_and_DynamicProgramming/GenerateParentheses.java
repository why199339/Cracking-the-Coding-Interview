package Recursive_and_DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

	public static void main(String[] args) {
		System.out.println(generateParentheses(3));
	}

	public static List<String> generateParentheses(int n) {
		if(n <= 0) {
			return null;
		}
		ArrayList<String> list = new ArrayList<>();
		backtrack(list, "", 0, 0, n);
		return list;
	}

	private static void backtrack(ArrayList<String> list, String str, int left, int right, int n) {
		if(str.length() == 2*n) {
			list.add(str);
		}
		if(left < n) {
			backtrack(list, str + "(", left + 1, right, n);
		}
		if(right < left) {
			backtrack(list, str + ")", left, right + 1, n);
		}
	}
}
