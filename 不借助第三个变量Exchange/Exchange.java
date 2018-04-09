public class Exchange {
	public static void main(String[] args) {
		int a = 100;
		int b = 1;
		
		a = a + b;
		b = a - b;
		a = a - b;
		
		System.out.println("a = " + a);
		System.out.println("b = " + b);
	}
}
