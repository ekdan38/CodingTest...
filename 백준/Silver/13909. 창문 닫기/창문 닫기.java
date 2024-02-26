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
    	StringBuilder sb = new StringBuilder();
    	int N = Integer.parseInt(br.readLine());
    	System.out.print((int)Math.sqrt(N));
    	//4, 9, 16과같이 제곱근일때 값이 증가함
        //
    }
}
//시간 초과 코드 
//    	boolean[] window = new boolean[N + 1];
//    	for(int i = 1; i < window.length; i++) {
//    		if(window[i])window[i] = false;
//    		else window[i] = true;
//    		for(int j = i + i; j < window.length; j += i) {
//        		if(window[j])window[j] = false;
//        		else window[j] = true;
//    		}
//        	for(boolean num:window)System.out.println(num);
//        	System.out.println();
//    	}
//    	int cnt = 0;
//    	for(int i = 1; i < window.length; i++) {
//    		if(window[i])cnt++;
//    		}
//    	bw.write(String.valueOf(cnt));
//    	bw.flush();
//    	bw.close();