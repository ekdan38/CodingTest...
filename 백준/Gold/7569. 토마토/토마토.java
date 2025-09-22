import java.util.*;
import java.io.*;

public class Main {
    static int M, N, H;
    static int[][][] map;
    static boolean[][][] visited;
    static final int[] dx = {-1, 0, 1, 0, 0, 0};
    static final int[] dy = {0, -1, 0, 1, 0, 0};
    static final int[] dz = {0, 0, 0, 0, -1, 1}; 
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H + 1][N + 1][M + 1];
        visited = new boolean[H + 1][N + 1][M + 1];

        for(int h = 1; h <= H; h++) {
            for(int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 1; j <= M; j++) {
                    int input = Integer.parseInt(st.nextToken());
                    map[h][i][j] = input;
                    if(input == 1) {
                        queue.offer(new int[]{h, i, j});
                        visited[h][i][j] = true;
                    }
                }
            }
        }

        bfs();

        int result = 0;
        boolean check = false;
        for(int h = 1; h <= H; h++) {
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= M; j++) {
                    if(map[h][i][j] == 0) {
                        check = true;
                        break;
                    } else if(map[h][i][j] > 0) {
                        result = Math.max(result, map[h][i][j]);
                    }
                }
            }
        }

        if(check) System.out.println(-1);
        else {
            if(result == 1) System.out.println(0);
            else System.out.println(result - 1);
        }
    }

    static void bfs() {
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int z = current[0];
            int x = current[1];
            int y = current[2];

            for(int i = 0; i < 6; i++) {
                int nz = z + dz[i];
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nz >= 1 && nz <= H && nx >= 1 && nx <= N && ny >= 1 && ny <= M) {
                    if(!visited[nz][nx][ny] && map[nz][nx][ny] == 0) {
                        map[nz][nx][ny] = map[z][x][y] + 1;
                        visited[nz][nx][ny] = true;
                        queue.offer(new int[]{nz, nx, ny});
                    }
                }
            }
        }
    }
}