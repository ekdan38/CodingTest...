import java.util.*;
import java.io.*;
public class Main{
    static int[] bridge;
    static int N;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        bridge = new int[N + 1];
        visited = new boolean[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            bridge[i] = Integer.parseInt(st.nextToken());
        }

        int start = Integer.parseInt(br.readLine());
        System.out.print(bfs(start));
    }
    static int bfs(int idx){
        int result = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(idx);
        visited[idx] = true;
        result++;

        while(!queue.isEmpty()){
            int current = queue.poll();

            int next = current + bridge[current];
            if(next >= 1 && next <= N){
                if(!visited[next]){
                    queue.offer(next);
                    visited[next] = true;
                    result++;
                }
            }

            next = current - bridge[current];
            if(next >= 1 && next <= N){
                if(!visited[next]){
                    queue.offer(next);
                    visited[next] = true;
                    result++;
                }
            }
        }
        return result;
    }
}