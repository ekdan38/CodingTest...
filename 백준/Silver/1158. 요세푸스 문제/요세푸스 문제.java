import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        /**
         * 1158 요세푸스 문제
         * 문제 분석: 1~N 번까지의 숫자들이 있고, K번째 숫자를 제거하면 된다.
         *          모든 숫자가 사라질때까지.....
         * 의사 결정:
         *          큐를 사용해서 풀어보자
         *          K이전의 숫자들은 다시 큐의 맨뒤로 넣어주자.
         *          k번째 숫자를 빼면 된다.
         *          이 과정을 큐의 사이즈가 1일때까지 반복하면된다.
         *          어차피 큐의 사이즈가 1이면 값이 1개만 남아서 그냥 빼주면 된다.(불필요한 연산 제거하자, ", "처리하기도 이게 더 편하다.)
         *
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < N; i++)
            queue.offer(i + 1);

        while(queue.size() > 1){
            for(int i = 0; i < K - 1; i++){
                queue.offer(queue.poll());
            }
            sb.append(queue.poll()).append(", ");
        }

        sb.append(queue.poll()).append(">");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

