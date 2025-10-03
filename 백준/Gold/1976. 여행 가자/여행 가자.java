import java.util.*;
import java.io.*;
public class Main{
    static List<List<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // BFS 풀이
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                int input = Integer.parseInt(st.nextToken());
                if(input == 1){
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }

        List<Integer> plans = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        while(M --> 0){
            plans.add(Integer.parseInt(st.nextToken()));
        }

        boolean result = bfs(N, plans.get(0), plans);
        bw.write(result ? "YES" : "NO");
        bw.flush();
    }

    static boolean bfs(int N, int start, List<Integer> plans){
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
                }
            }
        }
        return possible(visited, plans);
    }
    static boolean possible(boolean[] visited, List<Integer> plans){
        for(int n : plans){
            if(!visited[n]) return false;
        }
        return true;
    }
}