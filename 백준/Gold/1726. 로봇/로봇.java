import java.util.*;
import java.io.*;
public class Main{
    static int[][] graph;
    static int N, M;
    static int[] dx = {0, 0, 0, 1, -1};
    static int[] dy = {0, 1, -1, 0, 0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N + 1][M + 1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int sx = Integer.parseInt(st.nextToken());
        int sy = Integer.parseInt(st.nextToken());
        int sd = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int ex = Integer.parseInt(st.nextToken());
        int ey = Integer.parseInt(st.nextToken());
        int ed = Integer.parseInt(st.nextToken());

        int result = bfs(new int[]{sx, sy, sd}, new int[]{ex, ey, ed});
        System.out.print(result);
    }
    static int bfs(int[] start, int[] end){
        Queue<int[]> queue = new LinkedList<>();
        int[][][] dist = new int[N + 1][M + 1][4 + 1];
        for(int i = 0; i <= N; i++){
            for(int j = 0; j <= M; j++){
                Arrays.fill(dist[i][j], -1);
            }
        }

        // x, y, dir
        queue.offer(start);
        // x, y, dir
        dist[start[0]][start[1]][start[2]] = 0;

        while(!queue.isEmpty()){
            int[] currents = queue.poll();
            int cx = currents[0];
            int cy = currents[1];
            int dir = currents[2];

            if(cx == end[0] && cy == end[1] && dir == end[2]) return dist[cx][cy][dir];

            int nx, ny;
            // Go
            for(int i = 1; i <= 3; i++){
                nx = cx + dx[dir] * i;
                ny = cy + dy[dir] * i;

                if(nx < 1 || nx > N || ny < 1 || ny > M) continue;
                // 이전 칸 넘을 수 있으니 break 처리
                if(graph[nx][ny] == 1) break;
                if(dist[nx][ny][dir] != -1) continue;
                dist[nx][ny][dir] = dist[cx][cy][dir] + 1;
                queue.offer(new int[]{nx, ny, dir});
            }

            // Turn
            // 동 : 1, 서 : 2, 남 : 3, 북 : 4
            if(dir == 1 || dir == 2){
                for(int i = 0; i < 2; i++){
                    int nDir = 3 + i;
                    if(dist[cx][cy][nDir] != -1) continue;
                    dist[cx][cy][nDir] = dist[cx][cy][dir] + 1;
                    queue.offer(new int[]{cx, cy, nDir});
                }
            }
            else{
                for(int i = 1; i <= 2; i++){
                    int nDir = i;
                    if(dist[cx][cy][nDir] != -1) continue;
                    dist[cx][cy][nDir] = dist[cx][cy][dir] + 1;
                    queue.offer(new int[]{cx, cy, nDir});
                }
            }
        }
        return -1;
    }
}