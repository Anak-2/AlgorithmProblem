package grammar;

public class StringFormatting {

	public static void main(String[] args) {
		float a = (float) 0.1298;
		float a2 = (float)Math.floor(a*100)/100;
		System.out.printf("%.2f", a2);
	}

}
