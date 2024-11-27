import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        /**
         * 2075 N번째 큰 수
         * 문제 분석:
         *          N번째 큰수를 찾는 문제.
         *          시간과 메모리가 타이트하다.
         *
         * 의사 결정:
         *          단순 for문으로 리스트에 정리해서 풀 수 있겠지만
         *          시간과 메모리가 타이트하다.
         *          힙으로 풀어보자
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        //N * N 만큼 값을 받아온다.
        //N번째 큰 수를 구해야한다.
        //마지막에 최소힙의 size가 5이면 해당 루트 값이 n번째 큰 값이다.
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                int num = Integer.parseInt(st.nextToken());
                //우선 N만큼 힙을 채우고 항상 해당 size가 유지되도록 한다.
                if(minHeap.size() < N){
                    minHeap.offer(num);
                }
                //최소값을 빼주고 다른 값을 넣어주면 자동으로 최소힙의 루트는 힙 내부에서 5번째로 작은 값이다.
                else if(minHeap.peek() < num){
                    minHeap.poll();
                    minHeap.offer(num);
                }
            }
        }
        bw.write(String.valueOf(minHeap.peek()));

        bw.flush();
        bw.close();
    }
}