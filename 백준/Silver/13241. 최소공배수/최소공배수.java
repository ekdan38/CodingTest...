import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st;
    	st = new StringTokenizer (br.readLine()," ");
    	long A = Long.parseLong(st.nextToken());
    	long B = Long.parseLong(st.nextToken());
    	long a = Math.max(A, B);
    	long b = Math.min(A, B);
    	
    	bw.write(String.valueOf((a * b / GCD(a, b))));
    	bw.flush();
    	bw.close();
    }
    private static long GCD(long a, long b) {
    	while(b != 0) {
    		long temp = a % b;
    		a = b;
    		b = temp;
    		
    	}
    	return a;
    }
}
