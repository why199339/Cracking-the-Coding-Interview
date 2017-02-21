package Array_and_String;

import java.lang.annotation.Repeatable;

public class ReplaceSpaces {

	public static void main(String[] args) {
		char[] str = new char[100];
		str[0] = 'w';
		str[1] = ' ';
		str[2] = 'h';
		str[3] = ' ';
		str[4] = 'y';
		replaceSpaces(str, 5);
		System.out.println(new String (str));
	}

	public static void replaceSpaces(char[] str, int length) {
		if (str == null || str.length == 0) {
			return;
		}
		int count = 0;
		for (int i = 0; i < length; i++) {
			if (str[i] == ' ') {
				count++;
			}
		}
		int newLen = length + 2 * count;
		for (int i = length - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				str[newLen - 1] = '0';
				str[newLen - 2] = '2';
				str[newLen - 3] = '%';
				newLen -= 3;
			} else {
				str[newLen - 1] = str[i];
				newLen -= 1;
			}
		}
	}
}
