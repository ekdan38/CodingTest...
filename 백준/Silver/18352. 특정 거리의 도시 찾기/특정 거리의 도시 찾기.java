import java.util.*;
import java.io.*;
public class Main{
    static int N, M, K, X;
    static List<List<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        // 거리
        K = Integer.parseInt(st.nextToken());
        // 출발
        X = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        while(M --> 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, 1));
        }

        List<Integer> list = dijkstra();
        if(list.isEmpty()) sb.append(-1);
        else{
            for(int n : list){
                sb.append(n).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();

    }
    static List<Integer> dijkstra(){
        List<Integer> list = new ArrayList<>();
        Queue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        int[] dist = new int[N  + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        queue.offer(new Node(X, 0));
        dist[X] = 0;

        while(!queue.isEmpty()){
            Node cN = queue.poll();

            if(dist[cN.to] < cN.weight) continue;

            for(Node n : graph.get(cN.to)){
                if(dist[n.to] > n.weight + dist[cN.to]){
                    dist[n.to] = n.weight + dist[cN.to];
                    queue.offer(new Node(n.to, n.weight + dist[cN.to]));
                }
            }
        }

        for(int i = 1; i <= N; i++){
            if(dist[i] == K) list.add(i);
        }

        return list;
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