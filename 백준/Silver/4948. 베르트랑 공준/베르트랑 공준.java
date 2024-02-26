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
    	
    	int a = 0;
    	boolean[] arr;
    	while((a = Integer.parseInt(br.readLine()))!= 0) {
    		arr = new boolean[2*a + 1];   	
    		arr[0] = arr[1] = true;
    		for(int i = 2; i <= Math.sqrt(arr.length); i++) {
    			if(arr[i])continue;
    			for(int j = i * i; j < arr.length; j += i) {
    				arr[j] = true;
    			}
    		}
    		int cnt = 0;
    		for(int i = a + 1; i <= 2 * a; i++) {
    			if(!arr[i])cnt++;
    		}
    		sb.append(cnt+"\n");

    	}
    	bw.write(sb.toString());
    	bw.flush();
    	bw.close();

    }
}
