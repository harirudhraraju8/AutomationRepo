package JavaPragrams;

public class StringReverse {

	public static void main(String[] args) {

		String str = "God Shiva";

		String rev = "";

		for (int i = str.length() - 1; i >= 0; i--) {
			rev = rev + str.charAt(i);
		}
		System.out.println(rev);
	}
}
