import java.util.*;
import java.io.*;

public class Main{
    static List<List<Integer>> graph = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static boolean[] dfsVisited;
    static boolean[] bfsVisited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        dfsVisited = new boolean[N + 1];
        bfsVisited = new boolean[N + 1];

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for(int i = 0; i <= N; i++){
            Collections.sort(graph.get(i));
        }
        dfs(N, V);
        sb.append("\n");
        bfs(N, V);
        
        bw.write(sb.toString());
        bw.flush();
    }
    static void bfs(int N, int V){
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(V);
        bfsVisited[V] = true;
        sb.append(V).append(" ");

        while(!queue.isEmpty()){
            int current = queue.poll();

            for(int n : graph.get(current)){
                if(!bfsVisited[n]){
                    bfsVisited[n] = true;
                    queue.offer(n);
                    sb.append(n).append(" ");
                }
            }
        }
    }
    static void dfs(int N, int V){
        dfsVisited[V] = true;
        sb.append(V).append(" ");

        for(int n : graph.get(V)){
            if(!dfsVisited[n]) dfs(N, n);
        }
    }
}
