/*
*   입력:
*       1. 도둑들의 흔적에 대한 정보 infos
*       2. A 도둑이 경찰에 잡히는 최소 흔적 개수 n
*       3. B 도둑이 경찰에 잡히는 최소 흔적 개수 m
*
*   문제 분석:
*       1. 도둑 A, B 가 물건을 훔친다. 물건을 훔칠 때 각각 흔적을 남기는데 흔적이 누적되면 잡힌다.
*       2. 흔적 누적을 최소화 해야함 (흔적 개수 1 ~ 3)
*       => A : info[i][0] 개의 흔적 남김
*       => B : info[i][1] 개의 흔적 남김
*       3. A는 남긴 흔적의 누적이 n 개 이상이면 잡힌다.
*       4. B는 남긴 흔적의 누적이 m 개 이상이면 잡힌다.
*       3. 두 도둑이 모든 물건을 훔칠 때 A가 남긴 흔적의 누적값 최소 구해라(두 도둑 모두 잡힐수 밖에 없다면 -1 return)
*       
*   
*   출력:
*       1. 두 도둑이 모든 물건을 훔칠 때 A가 남긴 흔적의 누적값 최소 구해라(두 도둑 모두 잡힐수 밖에 없다면 -1 return)
*
**/
import java.util.*;

class Solution {
    static final int INF = 1000000;

    public int solution(int[][] info, int n, int m) {
        int[][] dp = new int[n][m];
         // 초기화 
        for (int[] row : dp) Arrays.fill(row, INF);
         // 초기 상태
        dp[0][0] = 0;

        for (int[] cost : info) {
            int costA = cost[0];
            int costB = cost[1];

            int[][] next = new int[n][m]; 
            for (int[] row : next) Arrays.fill(row, INF);

            
            for (int a = 0; a < n; a++) {
                for (int b = 0; b < m; b++) {
                    if (dp[a][b] == INF) continue;

                    // A가 훔치는 경우
                    int newA = a + costA;
                    if (newA < n) next[newA][b] = Math.min(next[newA][b], dp[a][b] + costA);

                    // B가 훔치는 경우
                    int newB = b + costB;
                    if (newB < m) next[a][newB] = Math.min(next[a][newB], dp[a][b]);
                }
            }

            dp = next;
        }

        // A의 최소 흔적 찾기
        int answer = INF;
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < m; b++) {
                answer = Math.min(answer, dp[a][b]);
            }
        }

        return answer == INF ? -1 : answer;
    }
}
