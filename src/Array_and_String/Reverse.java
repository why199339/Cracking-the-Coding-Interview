package Array_and_String;

public class Reverse {

	public static void main(String[] args) {
		String str = "hello";
		str = reverse(str);
		System.out.println(str);
	}

	public static String reverse(String str) {
		char[] chs = str.toCharArray();
		int start = 0;
		int end = str.length() - 1;
		while(start < end) {
			Character temp = chs[start];
			chs[start] = chs[end];
			chs[end] = temp;
			start ++;
			end --;
		}
		return String.valueOf(chs);
	}
}
