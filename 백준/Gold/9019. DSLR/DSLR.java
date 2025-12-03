import java.util.*;
import java.io.*;
public class Main{
    static int[] parent;
    static char[] command;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while(T --> 0){
            parent = new int[9999 + 1];
            command = new char[9999 + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            bfs(A, B);
            print(A, B);
        }

        bw.write(sb.toString());
        bw.flush();

    }
    static void print(int A, int B){
        StringBuilder midResult = new StringBuilder();
        while(B != A){
            midResult.append(command[B]);
            B = parent[B];
        }
        sb.append(midResult.reverse()).append("\n");
    }

    static void bfs(int A, int B){
        Queue<Integer> queue = new LinkedList<>();
        int[] dist = new int[9999 + 1];
        Arrays.fill(dist, -1);

        queue.offer(A);
        dist[A] = 0;

        while(!queue.isEmpty()){
            int c = queue.poll();

            if(c == B) return;

            // D
            int next = (c * 2) % 10_000;
            if(next >= 0 && next < 10_000 && dist[next] == -1){
                queue.offer(next);
                dist[next] = dist[c] + 1;
                parent[next] = c;
                command[next] = 'D';
            }
            // S
            next = (c == 0) ? 9999 : c - 1;
            if(next >= 0 && next < 10_000 && dist[next] == -1){
                queue.offer(next);
                dist[next] = dist[c] + 1;
                parent[next] = c;
                command[next] = 'S';
            }
            // L
            next = ((c % 1000) * 10) + (c / 1000);
            if(next >= 0 && next < 10_000 && dist[next] == -1){
                queue.offer(next);
                dist[next] = dist[c] + 1;
                parent[next] = c;
                command[next] = 'L';
            }
            // R
            next = ((c % 10) * 1000) + (c / 10);
            if(next >= 0 && next < 10_000 && dist[next] == -1){
                queue.offer(next);
                dist[next] = dist[c] + 1;
                parent[next] = c;
                command[next] = 'R';
            }
        }
    }

}