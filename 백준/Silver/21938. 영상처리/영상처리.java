import java.util.*;
import java.io.*;
public class Main{
    static int[][] graph;
    static boolean[][] visited;
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
        visited = new boolean[N + 1][M + 1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M * 3; j++){
                int rgb = Integer.parseInt(st.nextToken());
                graph[i][((j - 1) / 3) + 1] += rgb;
            }
        }

        int K = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                if(graph[i][j] / 3 >= K) graph[i][j] = 255;
                else graph[i][j] = 0;
            }
        }

        int result = 0;
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                if(graph[i][j] == 255 && !visited[i][j]){
                    dfs(i, j);
                    result++;
                }
            }
        }

        System.out.print(result);
    }
    static void dfs(int x, int y){
        visited[x][y] = true;

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 1 && nx <= N && ny >= 1 && ny <= M){
                if(!visited[nx][ny] && graph[nx][ny] == 255){
                    dfs(nx, ny);
                }
            }
        }
    }
}