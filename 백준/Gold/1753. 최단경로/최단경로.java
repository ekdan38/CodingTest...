import java.util.*;
import java.io.*;
public class Main{
    static List<List<Node>> graph = new ArrayList<>();
    static int[] distance;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        distance = new int[V + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        for(int i = 0; i <= V; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Node(to, weight));
        }

        dijkstra(K);

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= V; i++){
            if(distance[i] == Integer.MAX_VALUE) sb.append("INF");
            else sb.append(distance[i]);
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
    static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        pq.offer(new Node(start, 0));
        distance[start] = 0;

        while(!pq.isEmpty()){
            Node cNode = pq.poll();
            int current = cNode.to;
            int weight = cNode.weight;

            if(distance[current] < weight) continue;

            for(Node n : graph.get(current)){
                int nextNode = n.to;
                int nextWeight = weight + n.weight;

                if(distance[nextNode] > nextWeight){
                    pq.offer(new Node(nextNode, nextWeight));
                    distance[nextNode] = nextWeight;
                }
            }
        }
    }
    static class Node{
        int to;
        int weight;
        public Node(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }
}