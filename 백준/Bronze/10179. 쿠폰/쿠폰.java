import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int test = s.nextInt();
		double[] arr = new double[test];
		for (int i = 0; i < test; i++) {
			arr[i] = s.nextDouble();
			double price = (arr[i] - arr[i] * 0.2);
			System.out.println("$" + String.format("%.2f", price));
		}

	}

}