import java.util.*;
import java.io.*;
public class Main{
    static int N, M;
    static int[][] map;
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, -1, 0, 1};
    static Queue<int[]> queue = new LinkedList<>();
    static boolean[][] visited;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++){
                int input = Integer.parseInt(st.nextToken());
                map[i][j] = input;
                if(input == 1) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        bfs();
        int result = 0;
        boolean check = false;
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                if(map[i][j] == 0){
                    check = true;
                    break;
                }
                else if(map[i][j] > 0){
                    result = Math.max(result, map[i][j]);
                }
            }
        }
        if(check) bw.write("-1");
        else{
            if(result == 1) bw.write("0");
            else bw.write(String.valueOf(result - 1));
        }
        bw.flush();
    }
    static void bfs(){
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx > 0 && nx <= N && ny > 0 && ny <= M){
                    if(!visited[nx][ny] && map[nx][ny] == 0){
                        map[nx][ny] = map[cx][cy] + 1;
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}