import java.util.*;
import java.io.*;
public class Main{
    static int[][] map;
    static int N, M, T;
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = bfs();
        bw.write(result <= T ? String.valueOf(result) : "Fail");
        bw.flush();
    }
    static int bfs(){
        boolean[][][] visited = new boolean[N + 1][M + 1][2];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{1, 1, 0, 0});
        visited[1][1][0] = true;

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            int cd = current[2];
            int gram = current[3];
            if(cx == N && cy == M) return cd;
            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx > 0 && nx <= N && ny > 0 && ny <= M){
                    if(gram == 1 && !visited[nx][ny][1]){
                        queue.offer(new int[]{nx, ny, cd + 1, 1});
                        visited[nx][ny][1] = true;
                    }
                    else if(gram == 0 && !visited[nx][ny][0]){
                        if(map[nx][ny] == 0){
                            queue.offer(new int[]{nx, ny, cd + 1, 0});
                            visited[nx][ny][0] = true;
                        }
                        else if(map[nx][ny] == 2){
                            queue.offer(new int[]{nx, ny, cd + 1, 1});
                            visited[nx][ny][1] = true;
                        }
                    }
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}
