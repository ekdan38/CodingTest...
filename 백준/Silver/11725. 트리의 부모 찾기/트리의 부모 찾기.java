import java.io.*;
import java.util.*;

public class Main{
    static int[]parent;
    static boolean[] visited;
    static List<Integer>[] graph;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = N - 1;

        visited = new boolean[N + 1];
        graph = new ArrayList[N + 1];
        parent = new int[N + 1];
        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }


        bfs();
        for(int i = 2; i <= N; i++){
            sb.append(parent[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
    static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;

        while(!queue.isEmpty()){
            int current = queue.poll();

            for(int node : graph[current]){
                if(!visited[node]){
                    visited[node] = true;
                    queue.offer(node);
                    parent[node] = current;
                }
            }
        }
    }


}