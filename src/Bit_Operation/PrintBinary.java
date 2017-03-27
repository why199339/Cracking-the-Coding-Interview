package Bit_Operation;

public class PrintBinary {

	public static void main(String[] args) {
		System.out.println(printBinary(0.72));
	}

	public static String printBinary(double num) {
		if (num <= 0 || num >= 1) {
			return "ERROR";
		}
		StringBuffer sb = new StringBuffer();
		sb.append(".");
		while (num > 0) {
			double r = num * 2;
			if (r >= 1) {
				sb.append(1);
				num = r - 1;
			} else {
				sb.append(0);
				num = r;
			}
		}
		return sb.toString();
	}
}
