import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        /**
         * 12605 단어순서 뒤집기
         * 문제 분석: 단어 순서 뒤집는 문제인데 스택으로 풀면 된다.
         * 의사 결정:
         *          스택에 단어 집어넣고 꺼내면 된다.
         *
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            Stack<String> stack = new Stack<>();
            StringBuilder sb = new StringBuilder();
            sb.append("Case #" + (i + 1) + ":");
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                stack.push(st.nextToken());
            }
            while (!stack.isEmpty()){
                sb.append(" ").append(stack.pop());
            }
            bw.write(sb.toString() + "\n");
        }


        bw.flush();
        bw.close();
    }
}

