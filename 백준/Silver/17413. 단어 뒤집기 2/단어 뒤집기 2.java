import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        /**
         * 17413 단어 뒤집기 2
         * 문자열을 역순으로 출력해야한다.
         * 다만, <>안에 있는 문자열은 제외한다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        
        int idx = 0;
        Stack<Character> stack = new Stack<>();

        while(idx < str.length()) {
            // < 로 시작하면 > 나올때까지 bw에 값을 쓴다.
            if (str.charAt(idx) == '<') {
                while (true) {
                    if (str.charAt(idx) == '>') {
                        bw.write(str.charAt(idx++));
                        break;
                    } else bw.write(str.charAt(idx++));
                }
                // 공백 이라면 bw에 값을 쓴다.
            } else if (str.charAt(idx) == ' ') {
                bw.write(' ');
                idx++;

                // 단어라면
            } else {
                // stack에 push 한다. (단어인지 검사)
                while (idx < str.length() && str.charAt(idx) != ' ' && str.charAt(idx) != '<') {
                    stack.push(str.charAt(idx++));
                }
                // 뒤집어서 출력
                while (!stack.isEmpty()) {
                    bw.write(stack.pop());
                }
            }
        }

        bw.flush();
        bw.close();
    }
}

