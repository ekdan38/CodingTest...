import java.util.*;
import java.io.*;
public class Main{
    static List<List<Node>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] dist;
    static int N;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        for(int i = 0; i < N - 1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, weight));
            graph.get(b).add(new Node(a, weight));
        }

        int[] far = bfs(1);
        int[] result = bfs(far[0]);
        System.out.print(result[1]);

    }
    static int[] bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[N + 1];
        dist = new int[N + 1];

        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int current = queue.poll();

            for(Node next : graph.get(current)){
                int nextNode = next.to;
                int nextWeight = next.weight;

                if(visited[nextNode]) continue;

                visited[nextNode] = true;
                dist[nextNode] = dist[current] + nextWeight;
                queue.offer(nextNode);
            }
        }
        int maxNode = start;
        int max = 0;
        for(int i = 1; i <= N; i++){
            if(dist[i] > max) {
                max = dist[i];
                maxNode = i;
            }
        }
        return new int[]{maxNode, max};
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