import java.util.*;
import java.io.*;

public class Main {
    static int A, B, N, M;
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];

        queue.offer(new int[]{A, 0});
        visited[A] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int node = cur[0];
            int dist = cur[1];

            if (node == B) return dist;

            for (int next : graph.get(node)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[]{next, dist + 1});
                }
            }
        }
        return -1;
    }
}
