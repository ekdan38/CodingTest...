import java.util.*;
import java.io.*;
public class Main{
    static final int MIN = 0;
    static final int MAX = 100_000;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);

        int[] results = bfs(N, K);
        System.out.print(results[0] + "\n" + results[1]);

    }
    static int[] bfs(int N, int K){
        Queue<Integer> queue = new LinkedList<>();
        int[] dist = new int[MAX + 1];
        int[] ways = new int[MAX + 1];
        Arrays.fill(dist, -1);

        queue.offer(N);
        dist[N] = 0;
        ways[N] = 1;

        while(!queue.isEmpty()){
            int c = queue.poll();

            int[] moves = {c + 1, c - 1, c * 2};
            for(int m : moves){
                if(m < 0 || m > MAX) continue;
                // 미 방문
                if(dist[m] == -1){
                    queue.offer(m);
                    dist[m] = dist[c] + 1;
                    ways[m] = ways[c];
                }
                // 방문했는데, 최단거리 같으면 경로 추가
                else if(dist[c] + 1 == dist[m]){
                    ways[m] += ways[c];
                }

            }
        }
        return new int[]{dist[K], ways[K]};
    }
}