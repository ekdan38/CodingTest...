import java.util.*;
import java.io.*;
public class Main{
    static final int MAX = 100;
    static int[] graph = new int[MAX + 1];
    static int[] dist = new int[MAX + 1];
    static Map<Integer, Integer> moveMap = new HashMap<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 사다리
        int N = Integer.parseInt(st.nextToken());
        // 뱀
        int M = Integer.parseInt(st.nextToken());

        Arrays.fill(dist, -1);

        // 사다리 -> 1
        while(N --> 0){
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());

            graph[to] = 1;
            moveMap.put(to, from);
        }

        // 뱀 -> 2
        while(M --> 0){
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());

            graph[to] = 2;
            moveMap.put(to, from);
        }

        int result = bfs();
        System.out.print(result);
    }
    static int bfs(){
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);
        dist[1] = 0;

        while(!queue.isEmpty()){
            int c = queue.poll();

            if(c == MAX) return dist[c];

            for(int i = 1; i <= 6; i++){
                int n = c + i;

                if(n > MAX) continue;

                // 사다리 or 뱀
                if(graph[n] == 1 || graph[n] == 2){
                    n = moveMap.get(n);
                }

                if(dist[n] != -1) continue;
                queue.offer(n);
                dist[n] = dist[c] + 1;
            }
        }
        return -1;
    }
}