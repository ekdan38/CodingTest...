import java.util.*;
import java.io.*;
public class Main{
    static int N, M;
    static List<List<Edge>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        while(M --> 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Edge(b, weight));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int result = dijkstra(start, end);
        System.out.print(result);
    }
    static int dijkstra(int start, int end){
        Queue<Edge> queue = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[start] = 0;
        queue.offer(new Edge(start, 0));

        while(!queue.isEmpty()){
            Edge current = queue.poll();
            if(current.to == end) return dist[current.to];

            if(dist[current.to] < current.weight) continue;

            for(Edge n : graph.get(current.to)){
                int nextWeight = n.weight + dist[current.to];
                if(dist[n.to] > nextWeight){
                    dist[n.to] = nextWeight;
                    queue.offer(new Edge(n.to, nextWeight));
                }
            }
        }
        return -1;
    }
    static class Edge{
        int to;
        int weight;
        public Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }
}