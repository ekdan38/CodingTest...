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
    	int T = Integer.parseInt(br.readLine());
    	for(int i = 0; i < T; i++) {
    		String str = br.readLine();
        	Stack<Integer> stack = new Stack<>();
    		boolean check = true;
    		for(int j = 0; j < str.length(); j++) {
    			if(str.charAt(j) == '(')stack.push(1);
    			else if(str.charAt(j) == ')') {
    				if(stack.empty()) {
    					check = false;
    					break;
    				}
    				else if(!stack.empty()) {
    					stack.pop();
    				}
    			}
    		}
    		if(check) {
    			if(stack.empty())sb.append("YES\n");
    			else sb.append("NO\n");
    		}
    		else if(!check)sb.append("NO\n");
    	}
    	bw.write(sb.toString());
    	bw.flush();
    	bw.close();
    }
}
