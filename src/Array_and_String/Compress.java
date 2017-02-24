package Array_and_String;

public class Compress {

	public static void main(String[] args) {
		String str = "aabcccccaaa";
		System.out.println(compress(str));
	}

	public static String compress(String str) {
		int size = compressSize(str);
		if (size >= str.length()) {
			return str;
		}
		StringBuffer sb = new StringBuffer();
		char last = str.charAt(0);
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if(str.charAt(i) == last) {
				count ++;
			} else {
				sb.append(last).append(count);
				count = 1;
				last = str.charAt(i);
			}
		}
		sb.append(last).append(count);
		return sb.toString();
	}

	private static int compressSize(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		int last = str.charAt(0);
		int count = 1;
		int size = 0;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == last) {
				count++;
			} else {
				last = str.charAt(i);
				size += 1 + String.valueOf(count).length();
				count = 1;
			}
		}
		size += 1 + String.valueOf(count).length();
		return size;
	}
}
