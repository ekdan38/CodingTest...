import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        Stack<Character> stack = new Stack<>();

        int result = 0;
        int mid = 1;
        boolean chk = false;
        for(int i = 0; i < str.length(); i++){
            char current = str.charAt(i);
            if(current == '('){
                stack.push(current);
                mid *= 2;
            }
            else if(current == '['){
                stack.push(current);
                mid *= 3;
            }
            else if (!stack.isEmpty()){
                if(current == ')' && stack.peek() == '('){
                    stack.pop();
                    if(str.charAt(i - 1) == '(') result += mid;
                    mid /= 2;
                }
                else if(current == ']' && stack.peek() == '['){
                    stack.pop();
                    if(str.charAt(i - 1) == '[') result += mid;
                    mid /= 3;
                }
                else {
                    chk = true;
                    break;
                }
            }
            else{
                chk = true;
                break;
            }
        }
        if(chk || !stack.isEmpty()) bw.write("0");
        else bw.write(String.valueOf(result));
        bw.flush();
    }
}