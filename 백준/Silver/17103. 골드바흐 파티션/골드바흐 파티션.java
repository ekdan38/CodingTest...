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
    	StringBuilder sb = new StringBuilder();
    	int T = Integer.parseInt(br.readLine());
    	for(int i = 0; i < T; i++) {
    		int cnt = 0;
    		int N = Integer.parseInt(br.readLine());
    		
    		boolean[] arr = new boolean[N + 1];
    		arr[0] = arr[1] = true;
    		
    		for(int j = 2; j <= Math.sqrt(arr.length); j++) {
    			if(arr[j])continue;
    			for(int k = j * j; k < arr.length; k += j) {
    				arr[k] = true;
    			}
    		}
    		
    		for(int j = 2; j < arr.length; j++) {
    			if(!arr[j]) {
    				if(N - j == j)cnt += 2;
    				else if(!arr[N - j])cnt++;
    			}
    		}
    		
    		sb.append(cnt/2+"\n");
    	}
    	bw.write(sb.toString());
    	bw.flush();
    	bw.close();

    }
}
