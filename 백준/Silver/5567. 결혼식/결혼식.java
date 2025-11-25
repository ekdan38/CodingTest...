import java.util.*;
import java.io.*;
public class Main{
    static int N, M;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }
        visited = new boolean[N + 1];

        while(M --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        System.out.print(bfs());
    }
    static int bfs(){
        List<Integer> friends = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        visited[1] = true;
        // node, depth
        queue.offer(new int[]{1, 0});

        while(!queue.isEmpty()){
            int[] currents = queue.poll();
            int current = currents[0];
            int depth = currents[1];
            if(depth == 1 || depth == 2) friends.add(current);

            for(int n : graph.get(current)){
                if(visited[n]) continue;
                if(depth + 1 > 2) continue;
                queue.offer(new int[]{n, depth + 1});
                visited[n] = true;
            }
        }
        return friends.size();
    }
}