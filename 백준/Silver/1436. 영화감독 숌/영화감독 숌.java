import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	int output = 0;
    	int cnt = 0;
    	while(true) {
    		if(cnt == N)break;
    		output++;
    		if(String.valueOf(output).contains("666")) {
    			cnt++;
    		}
    	}
    	System.out.print(output);
    	}
    }