import java.util.*;
import java.io.*;
public class Main{
    static List<List<Node>> graph = new ArrayList<>();
    static int[] distance;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Node(to, weight));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);

        bw.write(String.valueOf(distance[end]));
        bw.flush();

    }
    static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        pq.offer(new Node(start, 0));
        distance[start] = 0;

        while(!pq.isEmpty()){
            Node cNode = pq.poll();
            int node = cNode.to;
            int weight = cNode.weight;

            if(distance[node] < weight) continue;

            for(Node next : graph.get(node)){
                int nextNode = next.to;
                int nextWeight = weight + next.weight;

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