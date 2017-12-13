package datastructure.string;

public class SkipBlank {
	public static void main(String[] args) {
		String str = "aa bb    cc  dd  ee   cs ";
		String s = "";
		for (int i = 0; i < str.length() - 1; i++) {
			if ((int) str.charAt(i) == 32) {
				continue;
			}
			s += str.charAt(i);
		}
		if ((int) str.charAt(str.length() - 1) != 32)
			s += str.charAt(str.length() - 1);
		
		String s2=str.replace(" ", "");
		System.out.println(s);
		System.out.println(s2);
		
	}
}
