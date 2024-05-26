import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st2.nextToken());
		int D = Integer.parseInt(st2.nextToken());
		
		if((A + D) > (B + C)) {
			System.out.println(B + C);
		}else {
			System.out.println(A + D);
		}
	}

}