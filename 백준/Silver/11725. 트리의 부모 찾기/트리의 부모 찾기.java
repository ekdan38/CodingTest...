import java.util.*;
import java.io.*;
public class Main{
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = N - 1;

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        while(M --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.get(A).add(B);
            graph.get(B).add(A);
        }

        int[] arr = bfs(N);
        StringBuilder sb = new StringBuilder();
        for(int i = 2; i < arr.length; i++){
            sb.append(arr[i]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
    static int[] bfs(int N){
        int[] arr = new int[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        boolean[] visited = new boolean[N + 1];
        visited[1] = true;

        while(!queue.isEmpty()){
            int current = queue.poll();
            for(int n : graph.get(current)){
                if(!visited[n]){
                    visited[n] = true;
                    queue.offer(n);
                    arr[n] = current;
                }
            }
        }
        return arr;
    }
}