import java.util.*;
import java.io.*;
public class Main{
    static int N, M, A, B, K;
    static int[][] graph;
    static int[][] dist;
    static int sx, sy, ex, ey;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][M + 1];
        dist = new int[N + 1][M + 1];
        for(int i = 0; i <= N; i++){
            Arrays.fill(dist[i], -1);
        }

        while(K --> 0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = 1;
        }

        st = new StringTokenizer(br.readLine());
        sx = Integer.parseInt(st.nextToken());
        sy = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        ex = Integer.parseInt(st.nextToken());
        ey = Integer.parseInt(st.nextToken());

        int result = bfs();
        System.out.print(result);
    }
    static int bfs(){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sx, sy});
        dist[sx][sy] = 0;

        while(!queue.isEmpty()){
            int[] currents = queue.poll();
            int cx = currents[0];
            int cy = currents[1];

            if(cx == ex && cy == ey) return dist[cx][cy];

            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                // 경계 검사
                if(nx < 1 || nx > N - A + 1 || ny < 1 || ny > M - B + 1) continue;

                boolean isBlock = false;
                for(int n = nx; n < nx + A; n++){
                    if(isBlock) break;
                    for(int m = ny; m < ny + B; m++){
                        if(graph[n][m] == 1){
                            isBlock = true;
                            break;
                        }
                    }
                }

                if(!isBlock && dist[nx][ny] == -1){
                    queue.offer(new int[]{nx, ny});
                    dist[nx][ny] = dist[cx][cy] + 1;
                }
            }
        }
        return -1;
    }
}