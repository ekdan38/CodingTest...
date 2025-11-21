import java.util.*;
import java.io.*;
public class Main{

    static int[][] graph;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] hx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] hy = {-2, -1, 1, 2, 2, 1, -1, -2};

    static int K, N, M;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[M + 1][N + 1];

        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = bfs();
        System.out.print(result);
    }
    static int bfs(){
        Queue<int[]> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[M + 1][N + 1][K + 1];

        // x, y, dis, useHorse
        queue.offer(new int[]{1, 1, 0, 0});
        visited[1][1][0] = true;

        while(!queue.isEmpty()){
            int[] currents = queue.poll();
            int cx = currents[0];
            int cy = currents[1];
            int cd = currents[2];
            int useHorse = currents[3];

            if(cx == M && cy == N) return cd;

            if(useHorse < K){
                for(int i = 0; i < 8; i++){
                    int nx = cx + hx[i];
                    int ny = cy + hy[i];

                    if(nx >= 1 && nx <= M && ny >= 1 && ny <= N){
                        if(graph[nx][ny] == 1) continue;
                        if(!visited[nx][ny][useHorse + 1]){
                            queue.offer(new int[]{nx, ny, cd + 1, useHorse + 1});
                            visited[nx][ny][useHorse + 1] = true;
                        }
                    }
                }
            }
            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx >= 1 && nx <= M && ny >= 1 && ny <= N){
                    if(graph[nx][ny] == 1) continue;
                    if(!visited[nx][ny][useHorse]){
                        queue.offer(new int[]{nx, ny, cd + 1, useHorse});
                        visited[nx][ny][useHorse] = true;
                    }
                }
            }

        }
        return -1;
    }
}