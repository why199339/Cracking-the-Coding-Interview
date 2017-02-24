package Array_and_String;

public class IsRotation {

	public static void main(String[] args) {

	}

	public static boolean isRotation(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
			return false;
		}
		return isSubString(s1 + s1, s2);
	}

	private static boolean isSubString(String s1, String s2) {
		return false;
	}
}
