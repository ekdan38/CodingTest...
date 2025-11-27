import java.util.*;
import java.io.*;
public class Main{
    static int[][] graph;
    static boolean[][] visited;
    static int N, M;
    static int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        List<int[]> searchList = new ArrayList<>();

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] == 1) searchList.add(new int[]{i, j});
            }
        }

        int result = 0;
        for(int[] s : searchList){
            if(!visited[s[0]][s[1]]){
                dfs(s);
                result++;
            }
        }

        System.out.print(result);
    }

    static void dfs(int[] c){
        int x = c[0];
        int y = c[1];

        visited[x][y] = true;

        for(int i = 0; i < dx.length; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 1 && nx <= N && ny >= 1 && ny <= M){
                if(!visited[nx][ny] && graph[nx][ny] == 1){
                    dfs(new int[]{nx, ny});
                }
            }
        }
    }
}