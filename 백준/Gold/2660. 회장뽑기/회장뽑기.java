import java.io.*;
import java.util.*;

/**
 * 2660 회장뽑기
 *
 * 입력:
 *      1. 첫째 줄 회원의 수 (1 ~ 50)
 *      2. 둘째 줄 부터 한줄에 두개의 회원 번호, 서로 친구 의미 (1 ~ 회원 수)
 *      3. 마지막 줄은 -1 -1
 *
 *문제 분석:
 *      1. 어느 회원이 모든 회원과 친구이면 점수 1점
 *      2. 어느 회원이 모든 회원과 친구, 친구의 친구 이면 2점
 *      3. 어느 회원이 모든 회원과 친구, 친구의 친구, 친구의 친구의 친구이면 3점
 *      4. 어느 회원이 모든 친구와 친구, 친구의 친구, 친구의 친구의 친구, 친구의 친구의 친구의 친구이면 4점
 *      5. 어느 회원이 모든 친구와 친구, 친구의 친구, 친구의 친구의 친구, 친구의 친구의 친구의 친구,
 *      친구의 친구의 친구의 친구의  친구 이면 4점
 *      => 점수 산정 방식을 보면 모든 회원은 연결되어있다.
 *      => 연결된 노드의 이동 거리가 1이면 1점, 2이면 2점... 5면 5점이라는 뜻이다.
 *      => 이 점수중 최대값 찾으면 해당 회원의 점수가 된다.
 *
 *      6. 점수가 가장 작은 사람이 회장이다.
 *      => 플로이드 워셜 사용
 *  출력:
 *      1. 첫째 줄 회장 후보의 수
 *      2. 둘째 줄 회장 후보 오름차순
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int node = Integer.parseInt(br.readLine());
        // 인접 행렬 사용
        // index 1번부터 사용
        int [][] dist = new int[node + 1][node + 1];
        for(int i = 1; i <= node; i++){
            for(int j = 1; j <= node; j++){
                // 자기 자신 제외
                if(i == j) dist[i][j] = 0;
                // 최대 노드 50이다.
                else dist[i][j] = 50;
            }
        }

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            // 입력값 -1 -1 이면 입력 끝
            if(A == -1 && B == -1)break;

            // 양방향
            dist[A][B] = 1;
            dist[B][A] = 1;
        }


        // 플로이드 워셜
        for (int i = 1; i <= node; i++) {
            for (int j = 1; j <= node; j++) {
                for (int k = 1; k <= node; k++) {
                    if (dist[j][k] > dist[j][i] + dist[i][k]) {
                        dist[j][k] = dist[j][i] + dist[i][k];
                    }
                }
            }
        }

        // 각각 점수 구하자
        int []score = new int[node + 1];
        int min = 50;


        for(int i = 1; i <= node; i++){
            for(int j = 1; j <= node; j++){
                if(score[i] < dist[i][j]) score[i] = dist[i][j];
            }
            if(min > score[i]) min = score[i];
        }

        PriorityQueue<Integer> resultQueue = new PriorityQueue<>();
        for(int i = 1; i <= node; i++){
            if(score[i] == min) resultQueue.offer(i);
        }


        StringBuilder result = new StringBuilder();
        // 첫째 줄
        result.append(min).append(" ").append(resultQueue.size()).append("\n");
        // 둘째 줄
        while (!resultQueue.isEmpty()){
            result.append(resultQueue.poll()).append(" ");
        }

        bw.write(result.toString());
//        for(int i = 1; i <= node; i++){
//            for(int j = 1; j <= node; j++){
//                System.out.print(dist[i][j] + " ");
//            }
//            System.out.println();
//        }


        bw.flush();
        br.close();
        bw.close();
    }
}