import java.util.*;
import java.io.*;
public class Main{
    static int N = 8;
    static int M = 8;
    static char[][] graph = new char[N + 1][M + 1];
    static int[] dx = {0, 1, 1, 0, -1, -1, -1, 0, 1};
    static int[] dy = {0, 0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 1; i <= N; i++){
            String input = br.readLine();
            for(int j = 1; j <= M; j++){
                graph[i][j] = input.charAt(j - 1);
            }
        }

        int result = bfs();
        bw.write(String.valueOf(result));
        bw.flush();
    }
    static int bfs(){
        Queue<int[]> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[N + 1][M + 1][9];

        // x, y, time
        queue.offer(new int[]{8, 1, 0});
        visited[8][1][0] = true;

        while(!queue.isEmpty()){
            int[] currents = queue.poll();
            int cx = currents[0];
            int cy = currents[1];
            int ct = currents[2];

            if(cx == 1 && cy == 8) return 1;
            int nt = Math.min(ct + 1, 8);

            for(int i = 0; i < 9; i++){
                int nx = dx[i] + cx;
                int ny = dy[i] + cy;

                if(nx < 1 || nx > N || ny < 1 || ny > M) continue;
                if(visited[nx][ny][nt]) continue;
                if (nx - ct >= 1 && graph[nx - ct][ny] == '#') continue;
                if (nx - (ct + 1) >= 1 && graph[nx - (ct + 1)][ny] == '#') continue;

                visited[nx][ny][nt] = true;
                queue.offer(new int[]{nx, ny, nt});
            }
        }
        return 0;
    }
}