import java.util.*;
import java.io.*;
public class Main{
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }
        visited = new boolean[N + 1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
        }

        List<Integer> list = bfs(X, K);
        StringBuilder sb = new StringBuilder();
        if(list.isEmpty()) sb.append("-1");
        else {
            for(int n : list){
                sb.append(n).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
    static List<Integer> bfs(int start, int K){
        List<Integer> list = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0});
        visited[start] = true;

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int idx = current[0];
            int dis = current[1];

            for(int n : graph.get(idx)){
                if(!visited[n]){
                    queue.offer(new int[]{n, dis + 1});
                    visited[n] = true;
                    if(dis + 1 == K) list.add(n);
                }
            }
        }
        Collections.sort(list);
        return list;
    }
}