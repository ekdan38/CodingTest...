import java.util.*;
import java.io.*;
public class Main{
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }
        visited = new boolean[N + 1];

        while(M --> 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(b).add(a);
        }

        int target = Integer.parseInt(br.readLine());
        int result = bfs(target);

        System.out.print(result);
    }
    static int bfs(int target){
        int cnt = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(target);
        visited[target] = true;

        while(!queue.isEmpty()){
            int c = queue.poll();
            for(int n : graph.get(c)){
                if(!visited[n]){
                    queue.offer(n);
                    visited[n] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}