import java.util.Scanner;

public class Main {
    static int n; // 도시의 수
    static int[][] cost; // 비용 행렬
    static boolean[] visited; // 방문 여부
    static int minCost = Integer.MAX_VALUE; // 최소 비용 초기화

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        cost = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
            }
        }

        // 0번 도시부터 탐색 시작
        visited[0] = true;
        dfs(0, 0, 1, 0);

        System.out.println(minCost);
    }

    // DFS 메서드
    static void dfs(int start, int current, int count, int totalCost) {
        // 모든 도시를 방문한 경우
        if (count == n) {
            // 시작 도시로 돌아갈 수 있는 경우에만 계산
            if (cost[current][start] != 0) {
                minCost = Math.min(minCost, totalCost + cost[current][start]);
            }
            return;
        }

        // 모든 도시를 순회
        for (int i = 0; i < n; i++) {
            // 방문하지 않았고, 이동 가능한 경우
            if (!visited[i] && cost[current][i] != 0) {
                visited[i] = true;
                dfs(start, i, count + 1, totalCost + cost[current][i]);
                visited[i] = false; // 백트래킹
            }
        }
    }
}
