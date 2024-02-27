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
    		long n = Long.parseLong(br.readLine());
    		//
    		while(true) {
    			int cnt = 0;
    			for(long j = 2; j <= Math.sqrt(n); j++) {
    				if(n % j == 0) {
    					cnt++;
    					break;
    				}
    			}

    			if(cnt == 0) {
    				if(n == 0 || n == 1) {
    					n = 2;
    				}
    				sb.append(n+"\n");
    				break;
    			}
    			n++;
    		}
    		//
    	}
    	bw.write(sb.toString());
    	bw.flush();
    	bw.close();
    	
    }



}
