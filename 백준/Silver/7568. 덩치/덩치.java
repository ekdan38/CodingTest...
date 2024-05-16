import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] xy = new int[N][2];
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 2; j++) {
				xy[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < N; i++) {
			int count = 1;
			for(int j = 0; j < N; j++) {
				if(xy[i][0] < xy[j][0] && xy[i][1] < xy[j][1]) count++;
			}
			arr[i] = count;
		}
		for(int i = 0; i < N; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}