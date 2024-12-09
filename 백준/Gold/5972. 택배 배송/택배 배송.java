import java.io.*;
import java.util.*;

/**
 * 5972 택배 배송
 *
 * 입력:
 *      1. 첫째 줄 N, M (1 ~ 50,000) 최대 2,500,000,000
 *      2. 이후 M개 만큼 A, B, C가 주어진다.
 *
 *문제 분석:
 *      1. 시작점은 1이고 지점은 N이다.
 *      2. 1부터 N까지 가는데 C(가중치)가 가장 낮은 쪽으로 이동해야한다.
 *      => 다익스트라 사용
 *  출력:
 *      1. 1번부터 N까지 이동할때 최소 여물(갸중치)
 */

public class Main {
    static List<List<Edge>> graph;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 노드 수
        N = Integer.parseInt(st.nextToken());
        // 간선 수
        int M = Integer.parseInt(st.nextToken());

        // index 1번부터 사용하자
        graph = new ArrayList<>(N + 1);
        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            // 양방향 그래프
            graph.get(A).add(new Edge(B, C));
            graph.get(B).add(new Edge(A, C));
        }

        bw.write(Integer.toString(dijkstra()));
        bw.flush();
        br.close();
        bw.close();
    }
    static int dijkstra(){
        // 최소 힙, 우선 순위 큐
        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[1] = 0;
        queue.offer(new Edge(1, 0));

        while (!queue.isEmpty()){
            Edge current = queue.poll();
            int currentWight = current.weight;
            int currentNode = current.node;

            // 현재 weight가 dist의 최소 값보다 작으면 넘긴다.
            if(currentWight > dist[currentNode])continue;

            int size = graph.get(currentNode).size();
            for(int i = 0; i < size; i++){
                int nextNode = graph.get(currentNode).get(i).node;
                int nextWeight = currentWight + graph.get(currentNode).get(i).weight;

                if(nextWeight < dist[nextNode]){
                    dist[nextNode] = nextWeight;
                    queue.offer(new Edge(nextNode, nextWeight));
                }
            }

        }
        return dist[N];
    }

    static class Edge{
        int node;
        int weight;

        public Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
}