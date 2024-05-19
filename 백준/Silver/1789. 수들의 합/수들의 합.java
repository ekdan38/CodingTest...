import java.util.*;

public class Main {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		long s = in.nextLong();
		long plus = 1;
		long sum = 0;
		while(true) {
			sum += plus;
			if(sum>s) break;
			plus ++;
		}
		System.out.println(plus-1);
		
	}
}