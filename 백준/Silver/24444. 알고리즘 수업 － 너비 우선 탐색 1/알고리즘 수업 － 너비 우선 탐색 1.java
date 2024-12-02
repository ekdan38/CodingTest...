import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int[] visitOrder; // 각 정점의 방문 순서를 저장하는 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        // 그래프와 방문 여부 배열 및 방문 순서 배열 초기화
        visited = new boolean[N + 1];
        graph = new ArrayList<>(N + 1);
        visitOrder = new int[N + 1];

        // 그래프 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // 인접 리스트 오름차순 정렬
        for (int i = 1; i <= N; i++) {
            graph.get(i).sort(Integer::compareTo);
        }

        // BFS 실행
        bfs(R);

        // 방문 순서 출력
        for (int i = 1; i <= N; i++) {
            bw.write(visitOrder[i] + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        int order = 1; // 여기서 지역 변수로 방문 순서 초기화

        visitOrder[start] = order++; // 시작 정점의 방문 순서를 1로 설정

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // 현재 정점의 모든 인접 정점을 탐색
            for (int next : graph.get(current)) {
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                    visitOrder[next] = order++; // 방문 순서를 기록
                }
            }
        }
    }
}
