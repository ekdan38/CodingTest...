import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        /**
         * 3986 좋은 단어
         * stack에 문자열(0)번씩 넣으면서 값이 같으면 pop 아니면 push 하고
         * 최종 stack이 비어있으면 좋은 단어이다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();
            
            // 고정적으로 str의 0번째는 push
            stack.push(str.charAt(0));
            
            // stack peek했을때 같으면 pop
            for(int j = 1; j < str.length(); j++){
                if(!stack.isEmpty() && stack.peek() == str.charAt(j)){
                    stack.pop();
                }
                // 아니면 push
                else{
                    stack.push(str.charAt(j));
                }
            }
            // stack이 비어있으면 cnt++
            if(stack.isEmpty())cnt++;
        }


        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }
}

