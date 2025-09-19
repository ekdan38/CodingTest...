import java.util.*;
import java.io.*;

public class Main{
    static List<List<Integer>> graph = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static int[] parents;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // bfs 돌리면서 다음 탐색 범위가 현재 노드의 자식 노드이다.
        // 따라서 다음 탐색 범위의 부모는 현재 노드
        int N = Integer.parseInt(br.readLine());
        parents = new int[N + 1];

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        for(int i = 0; i < N - 1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        bfs(N, 1);
        for(int i = 2; i < N + 1; i++){
            sb.append(parents[i]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();

    }
    static void bfs(int Node, int start){
        boolean[] visited = new boolean[Node + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int current = queue.poll();
            for(int n : graph.get(current)){
                if(!visited[n]){
                    queue.offer(n);
                    visited[n] = true;
                    parents[n] = current;
                }
            }
        }
    }
}