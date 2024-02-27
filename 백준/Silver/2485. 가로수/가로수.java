import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st;
    	int N = Integer.parseInt(br.readLine());
    	int[] arr = new int[N];
    	for(int i = 0; i < N; i++) {
    		arr[i] = Integer.parseInt(br.readLine());
    	}

    	int distance = 0;
    	int temp = 0;
    	for(int i = 0; i < N - 1; i++) {
    		if((arr[i] - arr[i + 1]) < 0) {
    			int dis = -(arr[i] - arr[i + 1]);
        		temp = GCD(dis, temp);
    		}
    		else {
    			int dis = (arr[i] - arr[i + 1]);
        		temp = GCD(dis, temp);
    		}
    	}
    	System.out.print((arr[N-1]-arr[0])/temp + 1 - (arr.length));
    	
    }
    private static int GCD(int a, int b) {
    	while(b != 0) {
    		int r = a % b;
    		a = b;
    		b = r;
    	}
    	return a;
    }
}
