import java.util.*;
import java.io.*;
public class Main{
    static int F, S, G, U, D;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        int result = bfs();
        if(result == -1) System.out.print("use the stairs");
        else System.out.print(result);
    }

    static int bfs(){
        Queue<Integer> queue = new LinkedList<>();
        int[] dist = new int[F + 1];
        Arrays.fill(dist, -1);

        dist[S] = 0;
        queue.offer(S);

        int[] moves = {+U, -D};

        while(!queue.isEmpty()){
            int c = queue.poll();

            if(c == G) return dist[c];

            for (int move : moves) {
                int next = move + c;
                if (next >= 1 && next <= F) {
                    if (dist[next] == -1) {
                        queue.offer(next);
                        dist[next] = dist[c] + 1;
                    }
                }
            }
        }
        return -1;
    }
}
