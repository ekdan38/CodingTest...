import java.util.*;
import java.io.*;
public class Main{
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }
        visited = new boolean[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int targetA = Integer.parseInt(st.nextToken());
        int targetB = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());
        while(M --> 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int result = bfs(targetA, targetB);
        System.out.print(result);
    }
    static int bfs(int targetA, int targetB){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{targetA, 0});
        visited[targetA] = true;

        while(!queue.isEmpty()){
            int[] currents = queue.poll();
            int current = currents[0];
            int dist = currents[1];

            if(current == targetB) return dist;

            for(int n : graph.get(current)){
                if(!visited[n]){
                    queue.offer(new int[]{n, dist + 1});
                    visited[n] = true;
                }
            }
        }
        return -1;
    }
}