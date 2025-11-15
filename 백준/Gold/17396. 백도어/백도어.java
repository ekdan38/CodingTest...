import java.util.*;
import java.io.*;
public class Main{
    static List<List<Node>> graph = new ArrayList<>();
    static long[] distance;
    static int[] ward;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        distance = new long[N];
        Arrays.fill(distance, Long.MAX_VALUE);
        ward = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            graph.add(new ArrayList<>());
            ward[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Node(to, weight));
            graph.get(to).add(new Node(from, weight));

        }

        dijkstra(N);
        if(distance[N - 1] == Long.MAX_VALUE) bw.write("-1");
        else bw.write(String.valueOf(distance[N - 1]));
        bw.flush();

    }
    static void dijkstra(int N){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1.weight, o2.weight));
        pq.offer(new Node(0 , 0L));
        distance[0] = 0;

        while(!pq.isEmpty()){
            Node currentNode = pq.poll();
            int node = currentNode.to;
            long weight = currentNode.weight;

            if(distance[node] < weight) continue;

            for(Node next : graph.get(node)){
                int nextNode = next.to;
                long nextWeight = next.weight + weight;

                if(nextNode != N - 1 && ward[nextNode] == 1) continue;

                if(distance[nextNode] > nextWeight){
                    pq.offer(new Node(nextNode, nextWeight));
                    distance[nextNode] = nextWeight;
                }
            }
        }
    }
    static class Node{
        int to;
        long weight;
        public Node(int to, long weight){
            this.to = to;
            this.weight = weight;
        }
    }
}