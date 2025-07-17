
import java.io.*;
import java.util.*;
public class Main{

    static boolean[] visited;
    static List<Edge>[] graph;
    static int[] distance;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        visited = new boolean[V + 1];
        graph = new ArrayList[V + 1];
        distance = new int [V + 1];

        // distance 초기화
        Arrays.fill(distance, Integer.MAX_VALUE);
        // graph 초기화
        for(int i = 0; i <= V; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[from].add(new Edge(to, weight));
        }

        dijkstra(start);

        for(int i = 1; i < distance.length; i++){
            bw.write(distance[i] == Integer.MAX_VALUE ? "INF\n" : distance[i] + "\n");
        }



        bw.flush();
    }
    static void dijkstra(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.weight, b.weight));
        pq.offer(new Edge(start, 0));
        distance[start] = 0;

        while(!pq.isEmpty()){
            Edge current = pq.poll();
            int currentNode = current.to;
            if(visited[currentNode]) continue;
            for(Edge e : graph[currentNode]){
                int nextNode = e.to;
                int nextWeight = e.weight;
                if(distance[nextNode] > distance[currentNode] + nextWeight) {
                    distance[nextNode] = distance[currentNode] + nextWeight;
                    pq.offer(new Edge(nextNode, distance[nextNode]));
                }
            }
        }
    }

    static class Edge{
        int to;
        int weight;
        Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }
}