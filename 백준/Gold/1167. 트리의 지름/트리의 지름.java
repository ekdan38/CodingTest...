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

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());

            while(true){
                int to = Integer.parseInt(st.nextToken());
                if(to == -1) break;
                int dis = Integer.parseInt(st.nextToken());
                graph.get(start).add(new Node(to, dis));
                graph.get(to).add(new Node(start, dis));
            }
        }

        int target = bfs(1);
        int result = bfs(target);

        bw.write(String.valueOf(dist[result]));
        bw.flush();
    }
    static int bfs(int start){
        visited = new boolean[N + 1];
        dist = new int[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int current = queue.poll();
            for(Node n : graph.get(current)){
                if(!visited[n.to]){
                    queue.offer(n.to);
                    visited[n.to] = true;
                    dist[n.to] = dist[current] + n.dis;
                }
            }
        }

        int max = start;
        for (int i = 1; i <= N; i++) {
            if (dist[i] > dist[max]) max = i;
        }
        return max;
    }
    static class Node{
        int to;
        int dis;
        Node(int to, int dis){
            this.to = to;
            this.dis = dis;
        }
    }
}