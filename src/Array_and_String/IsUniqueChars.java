package Array_and_String;

public class IsUniqueChars {

	public static void main(String[] args) {

	}

	// Supose a-z
	public static boolean isUniqueChars1(String str) {
		if(str.length() > 256) {
			return false;
		}
		int n = 0;
		for(int i=0; i<str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if ((n & (1 << val)) > 0) {
				return false;
			}
			n = n | (1 << val);
		}
		return true;
	}
	
	// Suppose ASCII
	public static boolean isUniqueChars2(String str) {
		if(str.length() > 256) {
			return false;
		}
		boolean[] char_set = new boolean[256];
		for(int i=0; i< str.length(); i++) {
			int val = str.charAt(i);
			if(char_set[val]) {
				return false;
			}
			char_set[val] = true;
		}
		return true;
	}
}
