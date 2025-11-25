import java.util.*;
import java.io.*;
public class Main{
    static int N, M;
    static int[][] graph;
    static boolean[][] visited;
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

        List<int[]> outLines = new ArrayList<>();

        for(int i = 1; i<= N; i++){
            String line = br.readLine();
            for(int j = 1; j <= M; j++){
                graph[i][j] = line.charAt(j - 1) - '0';
                if(i == 1 && graph[i][j] == 0) outLines.add(new int[]{i, j});
            }
        }

        for(int[] n : outLines){
            int x = n[0];
            int y = n[1];
            if(!visited[x][y]) bfs(x, y);
        }

        boolean result = check();
        bw.write(result ? "YES" : "NO");
        bw.flush();
    }
    static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while(!queue.isEmpty()){
            int[] currents = queue.poll();
            int cx = currents[0];
            int cy = currents[1];

            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx >= 1 && nx <= N && ny >= 1 && ny <= M){
                    if(!visited[nx][ny] && graph[nx][ny] == 0){
                        queue.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }

    static boolean check(){
        for(int j = 1; j <= M; j++){
            if(graph[N][j] == 0 && visited[N][j]) return true;
        }
        return false;
    }
}