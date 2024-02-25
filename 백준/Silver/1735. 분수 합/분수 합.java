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
    	int[] arr = new int[4];
    	st = new StringTokenizer(br.readLine()," ");
    	for(int i = 0; i < 4; i++) {
    		if(i == 2)st = new StringTokenizer(br.readLine()," ");
    		arr[i] = Integer.parseInt(st.nextToken());//[0]분자1  [1]분모1 //  [2]분자2  [3]분모2
    	}
    	int A = Math.max(arr[1], arr[3]);
    	int B = Math.min(arr[1], arr[3]);
    	int bottom = A * B / GCD(A, B);
    	int top = ((bottom / arr[1]) * arr[0]) + ((bottom / arr[3]) * arr[2]);
    	A = Math.max(bottom, top);
    	B = Math.min(bottom, top);    	
    	if(GCD(A, B) == 1)System.out.print(top+" "+bottom);
    	else {
    		System.out.print( top / GCD(A, B)  + " " + bottom / GCD(A, B));
    	}
    
    }
    private static int GCD(int a, int b) {
    	if(b == 0)return a;
    	else return GCD(b, a % b);
    }
}