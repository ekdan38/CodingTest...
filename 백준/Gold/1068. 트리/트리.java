import java.util.*;
import java.io.*;
public class Main{
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            graph.add(new ArrayList<>());
        }
        visited = new boolean[N];

        int root = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int parent = Integer.parseInt(st.nextToken());
            if(parent == -1) root = i;
            else graph.get(parent).add(i);
        }

        int D = Integer.parseInt(br.readLine());

        int result = bfs(root, D);
        System.out.print(result);
    }
    static int bfs(int root, int D){
        int cnt = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);
        visited[root] = true;

        while(!queue.isEmpty()){
            int c = queue.poll();

            if (c == D) continue;

            int childCnt = 0;
            for (int n : graph.get(c)) {
                if (n == D) continue; 
                childCnt++;
            }
            if (childCnt == 0) cnt++;

            for(int n : graph.get(c)){
                if(n == D) continue;
                if(visited[n]) continue;

                queue.offer(n);
                visited[n] = true;
            }
        }
        return cnt;
    }

}