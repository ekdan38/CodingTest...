import java.util.*;
import java.io.*;

public class Main {
    static List<List<Parts>> graph = new ArrayList<>();
    static int[] inDegree;
    static int[][] need;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        inDegree = new int[N + 1];
        need = new int[N + 1][N + 1];

        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            graph.get(Y).add(new Parts(X, K));
            inDegree[X]++;
        }

        String result = topologicalSort();
        bw.write(result);
        bw.flush();
    }

    static String topologicalSort() {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i <= N; i++) {
            if(inDegree[i] == 0) {
                queue.offer(i);
                need[i][i] = 1;
            }
        }

        while(!queue.isEmpty()) {
            int current = queue.poll();

            for(Parts next : graph.get(current)) {
                for(int i = 1; i <= N; i++) {
                    need[next.to][i] += need[current][i] * next.quantity;

                }
                inDegree[next.to]--;
                if(inDegree[next.to] == 0) queue.offer(next.to);
            }
        }

        for(int i = 1; i <= N; i++) {
            if(need[N][i] > 0) sb.append(i).append(" ").append(need[N][i]).append("\n");
        }
        return sb.toString();
    }

    static class Parts {
        int to;
        int quantity;

        Parts(int to, int quantity) {
            this.to = to;
            this.quantity = quantity;
        }
    }
}
