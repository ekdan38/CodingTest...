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
    	StringTokenizer st;
    	String str;
		StringBuilder sb = new StringBuilder();
    	while(!(str = br.readLine()).equals(".")) {
    		boolean check = true;
    		Stack<Character> stack = new Stack<>();//( )
     		for(int i = 0; i < str.length(); i++) {
    			if(str.charAt(i) == '(')stack.push('(');
    			
    			else if(str.charAt(i) == '[')stack.push('[');
    			
    			else if(str.charAt(i) == ')') {
					if(stack.empty()) {
						check = false;
						break;
					}
					else {
						if(stack.peek() == '(')stack.pop();
						else {
							check = false;
							break;
						}
					}
				}
    			
    			else if(str.charAt(i) == ']') {
					if(stack.empty()) {
						check = false;
						break;
					}
					else {
						if(stack.peek() == '[')stack.pop();
						else {
							check = false;
							break;
						}
					}
				}
    			
    		}
     		if(check) {
     			if(stack.empty())sb.append("yes\n");
     			else sb.append("no\n");
     		}
     		else {
     			sb.append("no\n");
     		}
    	}
    	bw.write(sb.toString());
    	bw.flush();
    	bw.close();
    		
    }
}
