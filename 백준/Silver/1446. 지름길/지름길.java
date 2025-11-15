import java.util.*;
import java.io.*;
public class Main{
    static List<List<Node>> graph = new ArrayList<>();
    static int[] distance;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        distance = new int[D + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        for(int i = 0; i <= D; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < D; i++){
            graph.get(i).add(new Node(i + 1, 1));
        }

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());

            if(to > D) continue;
            graph.get(from).add(new Node(to, dis));
        }

        int result = dijkstra(D);
        bw.write(String.valueOf(result));
        bw.flush();

    }
    static int dijkstra(int D){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.dis - o2.dis);
        pq.offer(new Node(0, 0));
        distance[0] = 0;

        while(!pq.isEmpty()){
            Node current = pq.poll();
            if(current.dis > distance[current.to]) continue;

            for(Node next : graph.get(current.to)){
                int nextNode = next.to;
                int nextDis = next.dis + current.dis;
                if(distance[nextNode] > nextDis){
                    pq.offer(new Node(nextNode, nextDis));
                    distance[nextNode] = nextDis;
                }
            }
        }
        return distance[D];
    }
    static class Node{
        int to;
        int dis;
        public Node(int to, int dis){
            this.to = to;
            this.dis = dis;
        }
    }
}