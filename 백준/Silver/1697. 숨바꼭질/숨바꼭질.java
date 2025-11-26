import java.util.*;
import java.io.*;
public class Main{
    static final int MAX = 100_000;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        System.out.print(bfs(N, M));
    }
    static int bfs(int N, int M){
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[MAX + 1];

        queue.offer(new int[]{N, 0});
        visited[N] = true;

        while(!queue.isEmpty()){
            int[] currents = queue.poll();
            int c = currents[0];
            int dist = currents[1];

            if(c == M) return dist;

            int[] moves = {c + 1, c - 1, c * 2};
            for(int next : moves){
                if(next >= 0 && next <= MAX && !visited[next]){
                    queue.offer(new int[]{next, dist + 1});
                    visited[next] = true;
                }
            }
        }
        return -1;
    }
}