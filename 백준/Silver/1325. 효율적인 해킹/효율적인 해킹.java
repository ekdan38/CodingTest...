import java.util.*;
import java.io.*;
public class Main{
    static List<List<Integer>> graph = new ArrayList<>();
    static int N;
    static int[] result;
    static int max = -1;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        result = new int[N + 1];
        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(b).add(a);
        }

        for(int i = 1; i <= N; i++){
            bfs(i);
        }

        for(int i = 1; i <= N; i++){
            if(result[i] == max) bw.write(i + " ");
        }
        bw.flush();

    }
    static void bfs(int start){
        boolean[] visited = new boolean[N + 1];
        visited[start] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while(!queue.isEmpty()){
            int current = queue.poll();
            for(int n : graph.get(current)){
                if(!visited[n]){
                    visited[n] = true;
                    queue.offer(n);
                    result[start]++;
                }
            }
        }
        max = Math.max(result[start], max);
    }
}