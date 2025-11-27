import java.util.*;
import java.io.*;
public class Main{
    static int[][] graph;
    static int r1, c1, r2, c2, N;
    static int[] dx = {-2, -2, 0, 0, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        graph = new int[N][N];

        int result = bfs();
        System.out.print(result);
    }
    static int bfs(){
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> queue = new LinkedList<>();
        // x, y, dist
        queue.offer(new int[]{r1, c1, 0});
        visited[r1][c1] = true;

        while(!queue.isEmpty()){
            int[] currents = queue.poll();
            int cx = currents[0];
            int cy = currents[1];
            int dist = currents[2];

            if(cx == r2 && cy == c2) return dist;

            for(int i = 0; i < 6; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < N){
                    if(!visited[nx][ny]){
                        queue.offer(new int[]{nx, ny, dist + 1});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return -1;
    }
}