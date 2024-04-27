import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int headCount = sc.nextInt();
		int bodyCount = sc.nextInt();

		int maxHead = 0;
		int maxBody = 0;

		for(int i=0; i<headCount; i++) {
			int head = sc.nextInt();

			if(i == 0) {
				maxHead = head;
				continue;
			}

			maxHead = maxHead > head ? maxHead : head;
		}

		for(int i=0; i<bodyCount; i++) {
			int body = sc.nextInt();

			if(i == 0) {
				maxBody = body;
				continue;
			}

			maxBody = maxBody > body ? maxBody : body;
		}

		System.out.println(maxHead + maxBody);
	}
}
