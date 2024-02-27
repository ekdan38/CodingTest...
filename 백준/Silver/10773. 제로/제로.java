import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	Stack<Integer> stack = new Stack<>();
    	int K = Integer.parseInt(br.readLine());
    	for(int i = 0; i < K; i++) {
    		int num = Integer.parseInt(br.readLine());
    		if(num == 0 && !stack.empty())stack.pop();
    		else stack.push(num);
    	}
    	int sum = 0;
    	while(!stack.empty()) {
    		sum += stack.pop();
    	}
    	sb.append(sum);
    	bw.write(sb.toString());
    	bw.flush();
    	bw.close();
    	
    }
}
