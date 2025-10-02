import java.util.*;
import java.io.*;
public class Main{
    static List<List<Integer>> graph;
    static int[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 인접한 노드는 서로 다른 그룹이어야한다.
        // 인접한 노드 방문 안했으면 서로 다른 노드로 분류
        // 인접한 노드가 같은 그룹의 노드라면 실패
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(K --> 0){
            graph = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            for(int i = 0; i <= V; i++){
                graph.add(new ArrayList<>());
            }
            visited = new int[V + 1];

            for(int i = 0; i < E; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            boolean check = false;
            for(int i = 1; i <= V; i++){
                if(visited[i] == 0){
                    boolean result = bfs(i);
                    if(!result){
                        check = true;
                        break;
                    }
                }
            }
            if(check) sb.append("NO");
            else sb.append("YES");
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
    static boolean bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = -1;

        while(!queue.isEmpty()){
            int current = queue.poll();
            for(int n : graph.get(current)){
                if(visited[n] == 0) {
                    queue.offer(n);
                    visited[n] = -visited[current];
                }
                else if(visited[n] == visited[current]) {
                    return false;
                }
            }
        }
        return true;
    }
}