import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[] numbers;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[N + 1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		int cnt = 0;
		int low = 0, high = 0;
		int sum = numbers[low];
		while (true) {
			if (high >= N)break;
			if (sum > M) sum -= numbers[low++];
			else if (sum == M) {
				cnt++;
				sum += numbers[++high];
			} 
                else sum += numbers[++high];
		}
		System.out.println(cnt);
	}
}