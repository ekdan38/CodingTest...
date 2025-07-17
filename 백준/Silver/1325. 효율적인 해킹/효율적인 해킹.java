/**
 * <문제 분석>
 *     1번 컴퓨터로 시작해서 도달되는 노드들은 모두 감염된다.
 *     bfs로 풀이
 *
 */

import java.io.*;
import java.util.*;
public class Main{
    static boolean[] visited;
    static List<Integer>[] graph;
    static int[] result;
    static int max = -1;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        result = new int[N + 1];

        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[b].add(a);
        }

        for(int i = 1; i <= N; i++){
            bfs(i, N);
        }


        for(int i = 1; i <= N; i++){
            if(result[i] == max){
                sb.append(i).append(" ");
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
    static void bfs(int start, int N){
        int cnt = 0;
        visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int current = queue.poll();
            cnt++;
            for(int n : graph[current]){
                if(!visited[n]){
                    visited[n] = true;
                    queue.offer(n);
                }
            }
        }
        result[start] = cnt;
        max = Math.max(cnt, max);
    }
}