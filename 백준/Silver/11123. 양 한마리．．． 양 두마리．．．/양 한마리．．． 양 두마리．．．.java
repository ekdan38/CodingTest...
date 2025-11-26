import java.util.*;
import java.io.*;
public class Main{
    static char[][] graph;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            graph = new char[N + 1][M + 1];
            visited = new boolean[N + 1][M + 1];

            List<int[]> sheeps = new ArrayList<>();

            for(int i = 1; i <= N; i++){
                String line = br.readLine();
                for(int j = 1; j <= M; j++){
                    graph[i][j] = line.charAt(j - 1);
                    if(graph[i][j] == '#') sheeps.add(new int[]{i, j});
                }
            }

            int result = 0;
            for(int[] sheep : sheeps){
                int x = sheep[0];
                int y = sheep[1];
                if(!visited[x][y]) {
                    dfs(x, y, N, M);
                    result++;
                }
            }
            sb.append(result).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
    static void dfs(int x, int y, int N, int M){
        visited[x][y] = true;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 1 && nx <= N && ny >= 1 && ny <= M){
                if(!visited[nx][ny] && graph[nx][ny] == '#'){
                    dfs(nx, ny, N, M);
                }
            }
        }
    }
}