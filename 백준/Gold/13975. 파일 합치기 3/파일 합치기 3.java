import java.io.*;
import java.sql.Array;
import java.util.*;

/**
 * 13975 파일 합치기 3
 * 입력:
 *      1. 첫째 줄 T개의 테스트 케이스 수
 *      2. 테스트 케이스 마다 K (2 ~ 1,000,000), K만큼 파일
 *문제 분석:
 *      1. 각각 파일을 합친다. 2개씩 합치면서 최소비용을 구해라
 *      2. 작은 수부터 더해주는게 최소비용이 나온다. 최소 힙 사용, 연산하고 다시 힙에 넣어줘야한다.
 *
 * 수정 사항:
 *      1. sum 을 int로 선언했더니 누적합 범위를 벗어난다. long으로 수정..
 *      2. 큐도 Integer => Long
 * 출력:
 *      1. 모든 장을 합치는데 필요한 최소비용 출력
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){

            int K = Integer.parseInt(br.readLine());
            // 최소 힙
            PriorityQueue<Long> minHeap = new PriorityQueue<>();
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < K; j++){
                minHeap.offer(Long.parseLong(st.nextToken()));
            }

            long sum = 0;
            // 임시 파일 다시 넣어줄거여서 size가 1보다 클때만
            while(minHeap.size() > 1){
                Long result = minHeap.poll() + minHeap.poll();
                sum += result;
                minHeap.offer(result);
            }
            sb.append(sum).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}