import java.util.*;
import java.io.*;
public class Main{
    static int N, M, A, B;
    static final int MAX = 100_000;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 동규 N, 주미 M
        // 동규는 A, B만큼의 힘을 가진 콩콩이
        // + 1, -1, A, B 만큼 좌우, 현위치의 A배, B배

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        System.out.print(bfs());
    }
    static long bfs(){
        boolean[] visited = new boolean[MAX + 1];
        Queue<long[]> queue = new LinkedList<>();

        queue.offer(new long[]{N, 0});
        visited[N] = true;

        while(!queue.isEmpty()){
            long[] currents = queue.poll();
            long current = currents[0];
            long dist = currents[1];

            if(current == M) return dist;

            // +1
            long next = current + 1;
            if(next >= 0 && next <= MAX){
                if(!visited[(int)next]){
                    queue.offer(new long[]{next, dist + 1});
                    visited[(int)next] = true;
                }
            }
            // -1
            next = current - 1;
            if(next >= 0 && next <= MAX){
                if(!visited[(int)next]){
                    queue.offer(new long[]{next, dist + 1});
                    visited[(int)next] = true;
                }
            }
            // -A
            next = current - A;
            if(next >= 0 && next <= MAX){
                if(!visited[(int)next]){
                    queue.offer(new long[]{next, dist + 1});
                    visited[(int)next] = true;
                }
            }
            // +A
            next = current + A;
            if(next >= 0 && next <= MAX){
                if(!visited[(int)next]){
                    queue.offer(new long[]{next, dist + 1});
                    visited[(int)next] = true;
                }
            }
            // -B
            next = current - B;
            if(next >= 0 && next <= MAX){
                if(!visited[(int)next]){
                    queue.offer(new long[]{next, dist + 1});
                    visited[(int)next] = true;
                }
            }
            // +B
            next = current + B;
            if(next >= 0 && next <= MAX){
                if(!visited[(int)next]){
                    queue.offer(new long[]{next, dist + 1});
                    visited[(int)next] = true;
                }
            }
            // current * A
            next = current * A;
            if(next >= 0 && next <= MAX){
                if(!visited[(int)next]){
                    queue.offer(new long[]{next, dist + 1});
                    visited[(int)next] = true;
                }
            }
            // current * B
            next = current * B;
            if(next >= 0 && next <= MAX){
                if(!visited[(int)next]){
                    queue.offer(new long[]{next, dist + 1});
                    visited[(int)next] = true;
                }
            }
        }
        return -1;
    }
}