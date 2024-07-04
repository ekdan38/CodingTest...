import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c , d, e, f, min;
		
		if(5 <= a && a < 10) {
			c = b - 500;
			min = c;
		}else if(10 <= a && a < 15) {
			c = b - 500;
			d = b - (b / 100) * 10;
			min = Math.min(c, d);
		}else if(15 <= a && a < 20) {
			c = b - 500;
			d = b - (b / 100) * 10;
			e = b - 2000;
			min = Math.min(c, d);
			min = Math.min(min, e);
		}else if(a >= 20) {
			c = b - 500;
			d = b - (b / 100) * 10;
			e = b - 2000;
			f = b - (b / 100) * 25;
			min = Math.min(c, d);
			min = Math.min(min, e);
			min = Math.min(min, f);
			
		}else {
			min = b;
		}
		
		if(min < 0) {
			min = 0;
		}
		
		System.out.println(min);
		sc.close();
	}
}