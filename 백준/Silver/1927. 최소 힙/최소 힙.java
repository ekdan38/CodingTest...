import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        /**
         * 1927 최소 힙
         * 문제 분석:
         *          N의 범위 1 ~ 100,000
         *          x는 2^31보다 작은 자연수 또는 0
         *          최소 힙을 사용하는 문제
         *          x가 자연수이면 배열에 추가
         *          x가 0이면 최소값 출력하고 삭제
         *
         * 의사 결정:
         *          x가 2^31보다 작은 자연수이기때문에 int 사용가능
         *          최소힙 생성
         *          x가 자연수이면 배열에 추가
         *          x가 0이면 최소값 출력하고 삭제
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        //최소힙 생성
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i = 0; i < N; i++){
            int x = Integer.parseInt(br.readLine());
            //x가 0이면 
            if(x == 0){
                //x가 0이고 최소힙이 비어있으면 0 출력
                if(minHeap.isEmpty()){
                    sb.append(0).append("\n");
                }
                //x가 0이고 최소힙이 존재하면 최소값 출력, 삭제
                else{
                    sb.append(minHeap.poll()).append("\n");
                }
            }
            //x가 자연수이면 추가
            else{
                minHeap.offer(x);
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}