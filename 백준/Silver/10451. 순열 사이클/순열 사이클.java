import java.util.*;
import java.io.*;

public class Main{
    static boolean[] visited;
    static List<List<Integer>> graph;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while(T --> 0){
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            graph = new ArrayList<>();
            visited = new boolean[N + 1];

            for(int i = 0; i <= N; i++){
                graph.add(new ArrayList<>());
            }

            for(int i = 1; i <= N; i++){
                graph.get(i).add(Integer.parseInt(st.nextToken()));
            }

            int result = 0;
            for(int i = 1; i <= N; i++){
                if(!visited[i]){
                    dfs(i);
                    result++;
                }
            }
            bw.write(result + "\n");
        }
        bw.flush();
    }
    static void dfs(int n){
        visited[n] = true;
        if(!visited[graph.get(n).get(0)]) dfs(graph.get(n).get(0));
    }
}