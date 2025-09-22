import java.util.*;
import java.io.*;

public class Main{
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int N;
    static boolean check = false;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

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

        for(int i = 0; i < N; i++){
            visited = new boolean[N + 1];
            dfs(i, 0);
            if(check) break;
        }

        bw.write(check ? "1" : "0");
        bw.flush();

    }
    static void dfs(int node, int depth){
        if(depth == 4) {
            check = true;
            return;
        }
        visited[node] = true;
        for(int n : graph.get(node)){
            if(!visited[n]){
                dfs(n, depth + 1);
                visited[n] = false;
            }
        }
    }
}