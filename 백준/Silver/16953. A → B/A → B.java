import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        System.out.print(bfs(A, B));
    }
    static long bfs(int A, int B){
        Queue<long[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[B + 1];

        // node, dist
        queue.offer(new long[]{A, 1});
        visited[A] = true;

        while(!queue.isEmpty()){
            long[] currents = queue.poll();
            long current = currents[0];
            long dist = currents[1];

            if(current == B) return dist;

            // *2
            long next = current * 2;
            if(next <= B){
                if(!visited[(int)next]){
                    queue.offer(new long[]{next, dist + 1});
                    visited[(int)next] = true;
                }

            }

            // 맨 뒤 1 추가
            next = Long.parseLong(String.valueOf(current) + "1");
            if(next <= B){
                if(!visited[(int)next]){
                    queue.offer(new long[]{next, dist + 1});
                    visited[(int)next] = true;
                }
            }
        }
        return -1;
    }
}