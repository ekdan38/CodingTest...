import java.util.*;
import java.io.*;
public class Main{
    static List<List<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 도시의 개수 N, 도로의 개수 M, 거리 K, 출발 도시 X
        // 최단 거리가 K 인 값이 여러개면 오름차순
        // 최단 거리가 없으면 -1
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
        }

        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = bfs(N, K, X);
        if(pq.isEmpty()){
            sb.append("-1");
        }
        else {
            while(!pq.isEmpty()){
                sb.append(pq.poll()).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();

    }
    static PriorityQueue<Integer> bfs(int N, int K, int X){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N + 1];
        Queue<City> queue = new LinkedList<>();
        queue.offer(new City(X, 0));
        visited[X] = true;

        while(!queue.isEmpty()){
            City currentCity = queue.poll();
            int current = currentCity.current;
            int weight = currentCity.weight;
            if(weight == K) pq.offer(current);

            for(int n : graph.get(current)){
                if(!visited[n]){
                    visited[n] = true;
                    queue.offer(new City(n, weight + 1));
                }
            }
        }
        return pq;
    }
    static class City{
        int current;
        int weight;
        City(int current, int weight){
            this.current = current;
            this.weight = weight;
        }
    }
}
