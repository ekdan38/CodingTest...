/**
 ( 이면 push
 ) 이면 pop, empty라면 바로 중단하고 no
 마지막 인덱스까지 갔는데 empty아니라면 no
 */
import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while(T -- > 0){
            Stack<Character> stack = new Stack<>();
            boolean midCheck = false;
            String str = br.readLine();
            for(int i = 0; i < str.length(); i++){
                if(str.charAt(i) == '(') stack.push('(');
                else{
                    if(stack.isEmpty()) {
                        midCheck = true;
                        break;
                    }
                    else stack.pop();
                }
            }
            if(midCheck) bw.write("NO\n");
            else bw.write(stack.isEmpty() ? "YES\n" : "NO\n");
        }
        bw.flush();
    }
}