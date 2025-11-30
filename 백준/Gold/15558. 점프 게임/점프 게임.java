import java.util.*;
import java.io.*;
public class Main{
    static int N, K;
    static int[][] graph;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][2];

        String left = br.readLine();
        for(int i = 1; i <= N; i++){
            graph[i][0] = left.charAt(i - 1) - '0';
        }

        String right = br.readLine();
        for(int i = 1; i <= N; i++){
            graph[i][1] = right.charAt(i - 1) - '0';
        }

        boolean result = bfs();
        if(result) System.out.print(1);
        else System.out.print(0);
    }
    static boolean bfs(){
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N + 1][2];

        // idx, left Or right, time
        queue.offer(new int[]{1, 0, 0});
        // idx, left Or right
        visited[1][0] = true;

        while(!queue.isEmpty()){
            int[] currents = queue.poll();
            int idx = currents[0];
            int lr = currents[1];
            int time = currents[2];
            
            if (idx <= time) continue;

            // i + 1
            int next = idx + 1;
            if(next > N) return true;
            if(next > time){
                if(!visited[next][lr] && graph[next][lr] == 1){
                    queue.offer(new int[]{next, lr, time + 1});
                    visited[next][lr] = true;
                }
            }

            // i - 1
            next = idx - 1;
            if(next > N) return true;
            if(next > time){
                if(next >= 1 && !visited[next][lr] && graph[next][lr] == 1){
                    queue.offer(new int[]{next, lr, time + 1});
                    visited[next][lr] = true;
                }
            }

            // i + k
            next = idx + K;
            if(next > N) return true;
            if(next > time){
                if(!visited[next][(lr + 1) % 2] && graph[next][(lr + 1) % 2] == 1){
                    queue.offer(new int[]{next, (lr + 1) % 2, time + 1});
                    visited[next][(lr + 1) % 2] = true;
                }
            }
        }
        return false;
    }
}