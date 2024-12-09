import java.io.*;
import java.util.*;

/**
 * 2458 키 순서
 *
 * 입력:
 *      1. 첫째 줄 학생들의 수 N(2 ~ 500), 두 학생의 키를 비교한 횟수 M(0 ~ N(N-1)/2)
 *      2. 이후 M개의 줄에는 두 학생의 키를 비교한 결과 a, b (1 ~ N - 1)
 *      => 번호 a인 학생이 번호 b인 학생보다 키가 작다는 뜻 => a < b 라는 뜻
 *      => 단방향 관계
 *
 *문제 분석:
 *      1. 1 ~ N 번까지 학생이 있다, 키는 모두 다름, 입력값 보면 키의 관계를 나타낸다.
 *      2. 자신의 키가 몇번째인지 알 수 없는 학생의 수를 구해야한다.
 *      =>
 *
 *  출력:
 *      1. 첫째 줄 회장 후보의 수

 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // node 수
        int N = Integer.parseInt(st.nextToken());
        // 간선 수
        int M = Integer.parseInt(st.nextToken());

        // index 1번부터 사용
        int [][] dist = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(i == j) dist[i][j] = 0;
                else dist[i][j] = 500;
            }
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 단방향
            dist[a][b] = 1;
        }

        // 플로이드 워셜
        for(int k = 1; k <= N; k++){
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }


        // 키가 몇번째 인지 알수 없는 경우
        // => 다른 모든 노드들과 연결되어 자신의 키가 몇번째 인지 알 수 있다.
        // 단방향 그래프이기에 다른 노드가 해당 노드에 갈 수 있는지도 확인 해야된다.
        int[] result = new int[N + 1];
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                // dist[i][j] != 500 이면 연결 되어있다는 뜻이다.
                if(dist[i][j] != 500 && dist[i][j] != 0) {
                    // 이때는 양방향 고려
                    result[i]++;
                    result[j]++;
                }
            }
        }

        // 결과 값이 N - 1이라면 모든 노드랑 연결이 되어있다는 뜻
        int cnt = 0;
        for(int i = 1; i <= N; i++){
            if(result[i] == N - 1) cnt++;
        }

        bw.write(Integer.toString(cnt));
        bw.flush();
        br.close();
        bw.close();
    }
}