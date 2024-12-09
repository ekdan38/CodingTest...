import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int INF = 50; // 최대 거리로 초기화 (문제 조건에서 노드 최대 50)
        int n = Integer.parseInt(br.readLine());

        // 인접 행렬 초기화
        int[][] dist = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0; // 자기 자신으로 가는 경로는 0
        }

        // 관계 입력
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1) break;

            dist[a][b] = 1; // 친구 관계
            dist[b][a] = 1; // 양방향 관계
        }

        // 플로이드-워셜 알고리즘
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        // 각 회원의 점수 계산
        int[] scores = new int[n + 1];
        int minScore = INF;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                scores[i] = Math.max(scores[i], dist[i][j]); // 최댓값 계산
            }
            minScore = Math.min(minScore, scores[i]); // 최소 점수 찾기
        }

        // 회장 후보 찾기
        List<Integer> candidates = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (scores[i] == minScore) {
                candidates.add(i);
            }
        }

        // 결과 출력
        bw.write(minScore + " " + candidates.size() + "\n");
        for (int candidate : candidates) {
            bw.write(candidate + " ");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
