import java.util.*;
import java.io.*;
public class Main{
    static int[][] graph;
    static int N, M;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][M + 1];
        for(int i = 1; i <= N; i++){
            String input = br.readLine();
            for(int j = 1; j <= M; j++){
                graph[i][j] = input.charAt(j - 1) - '0';
            }
        }

        int result = bfs();
        bw.write(String.valueOf(result));
        bw.flush();
    }
    static int bfs(){
        Queue<int[]> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[N + 1][M + 1][2];

        // x, y, dist, wall
        queue.offer(new int[]{1, 1, 1, 0});
        // x, y, wall
        visited[1][1][0] = true;

        while(!queue.isEmpty()){
            int[] currents = queue.poll();
            int cx = currents[0];
            int cy = currents[1];
            int cd = currents[2];
            int cw = currents[3];

            if(cx == N && cy == M) return cd;

            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx < 1 || nx > N || ny < 1 || ny > M) continue;
                // 벽 부수기 가능
                if(cw == 0){
                    if(graph[nx][ny] == 1){
                        if(!visited[nx][ny][1]){
                            visited[nx][ny][1] = true;
                            queue.offer(new int[]{nx, ny, cd + 1, 1});
                        }
                    }
                    else{
                        if(!visited[nx][ny][0]){
                            visited[nx][ny][0] = true;
                            queue.offer(new int[]{nx, ny, cd + 1, 0});
                        }
                    }
                }
                // 벽 부수기 불가능
                else{
                    if(!visited[nx][ny][1]){
                        if(graph[nx][ny] == 0){
                            queue.offer(new int[]{nx, ny, cd + 1, 1});
                            visited[nx][ny][1] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }
}