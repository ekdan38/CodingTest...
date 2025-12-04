import java.util.*;
import java.io.*;
public class Main{
    static final int MIN = 0;
    static final int MAX = 100_000;
    static StringBuilder sb = new StringBuilder();
    static int[] parent = new int[MAX + 1];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);

        bfs(N, K);
        paths(K, N);

        bw.write(sb.toString());
        bw.flush();
    }

    private static void paths(int K, int N) {
        int p = K;
        List<Integer> paths = new ArrayList<>();
        paths.add(p);
        while(p != N){
            p = parent[p];
            paths.add(p);
        }
        Collections.reverse(paths);
        for(int n : paths){
            sb.append(n).append(" ");
        }
    }

    static void bfs(int N, int K){
        Queue<Integer> queue = new LinkedList<>();
        int[] dist = new int[MAX + 1];
        Arrays.fill(dist, -1);

        queue.offer(N);
        dist[N] = 0;

        while(!queue.isEmpty()){
            int c = queue.poll();

            if(c == K) sb.append(dist[c]).append("\n");

            int[] moves = {c + 1, c - 1, c * 2};
            for(int m : moves){
                if(m < 0 || m > MAX) continue;
                if(dist[m] == -1){
                    queue.offer(m);
                    dist[m] = dist[c] + 1;
                    parent[m] = c;
                }
            }
        }
    }
}