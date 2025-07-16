/**
 * <문제 분석>
 *     1번 컴퓨터로 시작해서 도달되는 노드들은 모두 감염된다.
 *     bfs로 풀이
 */

import java.io.*;
import java.util.*;

public class Main{
    static boolean[] visited;
    static List<Integer>[] graph;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        graph = new ArrayList[N + 1];

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

        for(int i = 1; i <= N; i++){
            Collections.sort(graph[i]);
        }

        dfs(start);
        sb.append("\n");
        visited = new boolean[N + 1];
        bfs(start);

        bw.write(sb.toString());
        bw.flush();
    }
    static void dfs(int currentNode){
        visited[currentNode] = true;
        sb.append(currentNode).append(" ");
        for(int node : graph[currentNode]){
            if(!visited[node]){
                visited[node] = true;
                dfs(node);
            }
        }
    }
    static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int current = queue.poll();
            sb.append(current).append(" ");

            for(int node : graph[current]){
                if(!visited[node]){
                    visited[node] = true;
                    queue.offer(node);
                }
            }
        }
    }


}