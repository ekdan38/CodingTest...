import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();


        int T = Integer.parseInt(br.readLine());
        while(T --> 0){
            Stack<Character> stack = new Stack<>();
            boolean isVPS = true;
            String input = br.readLine();
            for(int i = 0; i < input.length(); i++){
                char current = input.charAt(i);
                if(current == '(') stack.push(current);
                else if(current == ')') {
                    if(stack.isEmpty()){
                        isVPS = false;
                        break;
                    }
                    else stack.pop();
                }
            }
            if(!isVPS || !stack.isEmpty()) sb.append("NO");
            else sb.append("YES");
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
