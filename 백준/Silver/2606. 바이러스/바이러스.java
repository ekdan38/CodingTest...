import java.util.*;
import java.io.*;

public class Main{
    static boolean[] visited;
    static List<List<Integer>> graph = new ArrayList<>();
    static int result = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        
        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        bfs(1);
        bw.write(String.valueOf(result));
        bw.flush();
    }
    static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int current = queue.poll();
            for(int n : graph.get(current)){
                if(!visited[n]){
                    queue.offer(n);
                    visited[n] = true;
                    result++;
                }
            }
        }
    }
}