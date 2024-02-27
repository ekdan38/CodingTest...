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
    	int N = Integer.parseInt(br.readLine());
    	for(int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine()," ");
    		int a = Integer.parseInt(st.nextToken());
    		switch(a) {
    		case 1 : 
    			int num = Integer.parseInt(st.nextToken());
    			stack.push(num);
    			break;
    		case 2 : 
    			if(stack.empty())sb.append("-1\n");
    			else sb.append(stack.pop()+"\n");
    			break;	
    			
    		case 3 : 
    			sb.append(stack.size()+"\n"); //ㅇ
    			break;
    		case 4 : 
    			if(stack.empty())sb.append("1\n");
    			else sb.append("0\n");
    			break;
    		case 5 : 
    			if(stack.empty())sb.append("-1\n");
    			else sb.append(stack.peek()+"\n");
    			break;
    		}
    	}
    	bw.write(sb.toString());
    	bw.flush();
    	bw.close();
    	
    }
}
//1. 정수를 스택에 넣기 push
//2. 스택에 정수가 있따면 맨 위에 정수 빼고 출력 없으면 - 1
//3. 스택에 들어있는 정수의 개수 출력
//4. 스택이 비어있으면 1 아니면 0
//5. 스택에 정수가 잇으면 매위에 정수 출력 없으면 - 1