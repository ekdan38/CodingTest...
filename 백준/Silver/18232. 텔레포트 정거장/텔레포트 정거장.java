import java.util.*;
import java.io.*;
public class Main{
    static List<List<Integer>> teleport = new ArrayList<>();
    static int N, M, S, E;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= N; i++){
            teleport.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            teleport.get(a).add(b);
            teleport.get(b).add(a);
        }

        int result = bfs();
        System.out.print(result);

    }
    static int bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(S);
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;

        while(!queue.isEmpty()){
            int current = queue.poll();
            if(current == E) return dist[E];

            int next = current + 1;
            if(next >= 1 && next <= N){
                if(dist[next] > dist[current] + 1){
                    dist[next] = dist[current] + 1;
                    queue.offer(next);
                }
            }

            next = current - 1;
            if(next >= 1 && next <= N){
                if(dist[next] > dist[current] + 1){
                    dist[next] = dist[current] + 1;
                    queue.offer(next);
                }
            }


            for(int n : teleport.get(current)){
                if(n >= 1 && n <= N){
                    if(dist[n] > dist[current] + 1){
                        dist[n] = dist[current] + 1;
                        queue.offer(n);
                    }
                }
            }
        }
        return -1;
    }
}