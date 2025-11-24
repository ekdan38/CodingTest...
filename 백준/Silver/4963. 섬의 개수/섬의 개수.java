import java.util.*;
import java.io.*;
public class Main{
    static int[][] graph;
    static int w, h;
    static boolean[][] visited;
    static int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w == 0 && h == 0) break;

            graph = new int[h + 1][w + 1];
            visited = new boolean[h + 1][w + 1];

            for(int i = 0; i < h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < w; j++){
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = 0;
            for(int i = 0; i < h; i++){
                for(int j = 0; j < w; j++){
                    if(!visited[i][j] && graph[i][j] == 1){
                        dfs(i, j);
                        result++;
                    }
                }
            }
            sb.append(result).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
    static void dfs(int x, int y){
        visited[x][y] = true;
        for(int i = 0; i < 8; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx <= h && ny >= 0 && ny <= w){
                if(!visited[nx][ny]){
                    if(graph[nx][ny] == 1) dfs(nx, ny);
                }
            }
        }
    }
}