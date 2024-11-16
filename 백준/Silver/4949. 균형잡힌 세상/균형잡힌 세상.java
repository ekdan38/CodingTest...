import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        /**
         * 4949 균형잡힌 세상
         * stack에 문자열(0)번씩 넣으면서 값이 같으면 pop 아니면 push 하고
         * 최종 stack이 비어있으면 좋은 단어이다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;

        while (!(str = br.readLine()).equals(".")) {
            Stack<Character> stack = new Stack<>();
            boolean flag = true;

            // StringTokenizer 말고 toCharArray를 사용해보자.
            for (char ch : str.toCharArray()) {
                // ( or [ 면 push
                if (ch == '(' || ch == '[') {
                    stack.push(ch);
                }
                // )이고 stack의 최상단이 (이 아니면 만족 못함, 종료시키자
                // 맞으면 pop
                // form )( a trail 이런 상황도 고려 해줘야한다.... flag로 표시해주자.
                else if (ch == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        flag = false;
                        break;
                    }
                    stack.pop(); // 짝이 맞으면 pop
                }
                // ]이고 stack의 최상단이 [이 아니면 만족 못함, 종료시키자
                // 맞으면 pop
                else if (ch == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') { // 스택이 비어 있거나 짝이 안 맞음
                        flag = false;
                        break;
                    }
                    stack.pop();
                }
            }
            if (stack.isEmpty() && flag) bw.write("yes\n");
            else bw.write("no\n");
        }
        bw.flush();
        bw.close();
    }
}

