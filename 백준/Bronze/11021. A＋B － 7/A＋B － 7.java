
import java.util.StringTokenizer;
import java.io.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int Num = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 1; i < Num+1; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			bw.write("Case #"+i+": "+(A + B)+"\n");
		}
		bw.flush();

	}

}