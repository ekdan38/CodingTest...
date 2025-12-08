import java.util.*;
import java.io.*;
public class Main{
    static int[][] graph;
    static int N, M, hx, hy, ex, ey;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        hx = Integer.parseInt(st.nextToken());
        hy = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        ex = Integer.parseInt(st.nextToken());
        ey = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][M + 1];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.print(bfs());

    }
    static int bfs(){
        Queue<int[]> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[N + 1][M + 1][2];

        // x, y, dist, staff
        queue.offer(new int[]{hx, hy, 0, 0});
        visited[hx][hy][0] = true;

        while(!queue.isEmpty()){
            int[] currents = queue.poll();
            int cx = currents[0];
            int cy = currents[1];
            int cd = currents[2];
            int staff = currents[3];

            if(cx == ex && cy == ey) return cd;

            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx < 1 || nx > N || ny < 1 || ny > M) continue;

                // 벽이고
                if(graph[nx][ny] == 1){
                    // 스태프 사용 안했으면
                    if(staff == 0 && !visited[nx][ny][1]){
                        queue.offer(new int[]{nx, ny, cd + 1, 1});
                        visited[nx][ny][1] = true;
                    }
                    // 스태프 사용 했으면 아무것도 안함
                }
                // 일반 땅이면
                else{
                    if(!visited[nx][ny][staff]){
                        queue.offer(new int[]{nx, ny, cd + 1, staff});
                        visited[nx][ny][staff] = true;
                    }
                }
            }
        }
        return -1;
    }
}