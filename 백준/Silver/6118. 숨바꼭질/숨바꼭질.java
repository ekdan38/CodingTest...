import java.util.*;
import java.io.*;
public class Main{
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static Map<Integer, List<Integer>> depth = new HashMap<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= N ; i++){
            graph.add(new ArrayList<>());
        }
        visited = new boolean[N + 1];

        while(M --> 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int maxDepth = bfs();
        List<Integer> list = depth.get(maxDepth);
        int minNode = Collections.min(list);
        
        System.out.print(minNode + " " + maxDepth + " " + list.size());

    }
    static int bfs(){
        int maxDepth = 0;
        Queue<int[]> queue = new LinkedList<>();
        // node, dist
        queue.offer(new int[]{1, 0});
        visited[1] = true;

        while(!queue.isEmpty()){
            int[] currents = queue.poll();
            int c = currents[0];
            int dist = currents[1];

            for(int n : graph.get(c)){
                if(!visited[n]){
                    // depth 마다 노드 추가
                    depth.putIfAbsent(dist + 1, new ArrayList<>());
                    depth.get(dist + 1).add(n);
                    maxDepth = Math.max(maxDepth, dist + 1);
                    
                    queue.offer(new int[]{n, dist + 1});
                    visited[n] = true;
                }
            }
        }
        return maxDepth;
    }
}