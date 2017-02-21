package Array_and_String;

import java.util.Arrays;

public class Permutation {

	public static void main(String[] args) {
		String s = "dog";
		String t = "gdo";
		System.out.println(permutation_sort(s, t));
		System.out.println(permutation_hash(s, t));
	}

	public static boolean permutation_sort(String s, String t) {
		if(s == null || t == null) {
			return false;
		}
		if(s.length() != t.length()) {
			return false;
		}
		return sort(s).equals(sort(t));
	}

	private static String sort(String s) {
		char[] chs = s.toCharArray();
		Arrays.sort(chs);
		return new String(chs);
	}
	
	public static boolean permutation_hash(String s, String t) {
		int[] num = new int[256];
		for(char c : s.toCharArray()) {
			num[c] ++;
		}
		for(char c: t.toCharArray()) {
			num[c] --;
			if(num[c] < 0) {
				return false;
			}
		}
		return true;
	}
	
}
