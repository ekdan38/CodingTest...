import java.util.*;
import java.io.*;
public class Main{
    static List<List<Integer>> graph = new ArrayList<>();
    static int N, M;
    static int[] dist;
    static int min = Integer.MAX_VALUE;
    static int result;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        while(M --> 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for(int i = 1; i <= N; i++){
            dist = new int[N + 1];
            Arrays.fill(dist, -1);

            bfs(i);
        }

        System.out.print(result);
    }
    static void bfs(int node){
        int sum = 0;
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(node);
        dist[node] = 0;

        while(!queue.isEmpty()){
            int current = queue.poll();

            for(int n : graph.get(current)){
                if(dist[n] == -1){
                    queue.offer(n);
                    dist[n] = dist[current] + 1;
                }
            }
        }
        for(int i = 1; i <= N; i++){
            sum += dist[i];
        }

        if(sum < min) result = node;
        min = Math.min(min, sum);
    }
}