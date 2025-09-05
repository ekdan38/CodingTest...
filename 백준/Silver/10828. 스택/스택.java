import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        Stack<Integer> stack = new Stack<>();
        
        while(N --> 0){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            
            if(command.equals("push")){
                stack.push(Integer.parseInt(st.nextToken()));
            }
            else if(command.equals("pop")){
                if(stack.isEmpty()) sb.append("-1");
                else sb.append(stack.pop());
                sb.append("\n");
            }
            else if(command.equals("size")){
                sb.append(stack.size()).append("\n");
            }
            else if(command.equals("empty")){
                if(stack.isEmpty()) sb.append("1");
                else sb.append("0");
                sb.append("\n");
            }
            else if(command.equals("top")){
                if(stack.isEmpty()) sb.append("-1");
                else sb.append(stack.peek());
                sb.append("\n");
            }
        }
        
        bw.write(sb.toString());
        bw.flush();
    }
}